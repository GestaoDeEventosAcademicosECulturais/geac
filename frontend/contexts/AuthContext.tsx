"use client";

import {
  createContext,
  useContext,
  useEffect,
  useState,
  useCallback,
  useMemo,
  useRef,
} from "react";
import { usePathname } from "next/navigation";
import { AuthContextType, UserData } from "@/types/auth";
import { logoutAction } from "@/app/actions/auth";

const AuthContext = createContext<AuthContextType>({} as AuthContextType);

const SESSION_CACHE_TIME = 5 * 60 * 1000;

export function AuthProvider({
  children,
}: Readonly<{ children: React.ReactNode }>) {
  const [user, setUser] = useState<UserData | null>(null);
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [isLoading, setIsLoading] = useState(true);
  
  const lastCheckRef = useRef<number>(0);
  const isCheckingRef = useRef<boolean>(false);

  const pathname = usePathname();

  const checkSession = useCallback(async (force = false) => {
    const now = Date.now();
    
    if (!force && now - lastCheckRef.current < SESSION_CACHE_TIME) {
      return;
    }

    if (isCheckingRef.current) {
      return;
    }

    try {
      isCheckingRef.current = true;
      const res = await fetch("/api/me", { cache: "no-store" });

      if (res.ok) {
        const data = await res.json();
        setUser(data.user);
        setIsAuthenticated(true);
        lastCheckRef.current = now;
      } else {
        throw new Error("Não logado");
      }
    } catch {
      setUser(null);
      setIsAuthenticated(false);
      lastCheckRef.current = 0;
    } finally {
      setIsLoading(false);
      isCheckingRef.current = false;
    }
  }, []);

  useEffect(() => {
    checkSession(true);
  }, []);

  useEffect(() => {
    const protectedRoutes = ['/events', '/certificados', '/meus-eventos'];
    const isProtected = protectedRoutes.some(route => pathname.startsWith(route));
    
    if (isProtected) {
      checkSession();
    }
  }, [pathname, checkSession]);

  const logout = useCallback(async () => {
    try {
      await logoutAction();
    } finally {
      setUser(null);
      setIsAuthenticated(false);
      lastCheckRef.current = 0;
    }
  }, []);

  const login = useCallback(() => {
    lastCheckRef.current = 0;
    checkSession(true);
  }, [checkSession]);

  const contextValue = useMemo(
    () => ({
      user,
      isAuthenticated,
      logout,
      login,
      isLoading,
    }),
    [user, isAuthenticated, logout, login, isLoading],
  );

  return (
    <AuthContext.Provider value={contextValue}>{children}</AuthContext.Provider>
  );
}

export const useAuth = () => useContext(AuthContext);