"use client";

import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";
import { Navbar } from "@/components/navbar";
import { authService } from "@/lib/authService";

export default function LogoutPage() {
  const router = useRouter();
  const [isLoggingOut, setIsLoggingOut] = useState(false);

  useEffect(() => {
    // Verifica se o usuário está autenticado
    const isAuth = authService.isAuthenticated();
    
    if (!isAuth) {
      // Se não está autenticado, redireciona para signin
      router.push('/signin');
    }
  }, [router]);

  const handleLogout = async () => {
    const confirmLogout = window.confirm('Deseja realmente sair do sistema?');
    
    if (!confirmLogout) return;
    
    setIsLoggingOut(true);
    
    try {
      const result = await authService.logout();
      
      if (result.success) {
        // Redireciona para a página de login
        router.push('/signin');
        router.refresh();
      } else {
        alert(result.message);
        // Mesmo com erro, redireciona (dados locais já foram limpos)
        router.push('/signin');
        router.refresh();
      }
    } catch (error) {
      console.error('Erro inesperado ao fazer logout:', error);
      // Garante que o usuário seja deslogado mesmo com erro
      router.push('/signin');
      router.refresh();
    }
  };

  const handleCancel = () => {
    router.back();
  };

  return (
    <div className="flex min-h-screen flex-col bg-zinc-50 dark:bg-black font-sans">
      <Navbar />
      <main className="flex flex-1 items-center justify-center p-4">
        <div className="w-full max-w-md bg-white dark:bg-zinc-900 rounded-lg shadow-md p-8 border border-zinc-200 dark:border-zinc-800">
          <div className="text-center mb-8">
            <div className="mx-auto w-16 h-16 bg-red-100 dark:bg-red-900/20 rounded-full flex items-center justify-center mb-4">
              <svg 
                xmlns="http://www.w3.org/2000/svg" 
                className="h-8 w-8 text-red-600 dark:text-red-400" 
                viewBox="0 0 20 20" 
                fill="currentColor"
              >
                <path 
                  fillRule="evenodd" 
                  d="M3 3a1 1 0 00-1 1v12a1 1 0 102 0V4a1 1 0 00-1-1zm10.293 9.293a1 1 0 001.414 1.414l3-3a1 1 0 000-1.414l-3-3a1 1 0 10-1.414 1.414L14.586 9H7a1 1 0 100 2h7.586l-1.293 1.293z" 
                  clipRule="evenodd" 
                />
              </svg>
            </div>
            <h1 className="text-2xl font-bold text-zinc-900 dark:text-white mb-2">
              Sair do Sistema
            </h1>
            <p className="text-zinc-600 dark:text-zinc-400">
              Tem certeza que deseja encerrar sua sessão?
            </p>
          </div>

          <div className="space-y-3">
            <button
              onClick={handleLogout}
              disabled={isLoggingOut}
              className="w-full bg-red-600 hover:bg-red-700 disabled:bg-red-400 text-white font-semibold py-3 px-4 rounded-md transition duration-200 flex items-center justify-center"
            >
              {isLoggingOut ? (
                <>
                  <svg 
                    className="animate-spin -ml-1 mr-3 h-5 w-5 text-white" 
                    xmlns="http://www.w3.org/2000/svg" 
                    fill="none" 
                    viewBox="0 0 24 24"
                  >
                    <circle 
                      className="opacity-25" 
                      cx="12" 
                      cy="12" 
                      r="10" 
                      stroke="currentColor" 
                      strokeWidth="4"
                    />
                    <path 
                      className="opacity-75" 
                      fill="currentColor" 
                      d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"
                    />
                  </svg>
                  Saindo...
                </>
              ) : (
                'Sim, sair'
              )}
            </button>

            <button
              onClick={handleCancel}
              disabled={isLoggingOut}
              className="w-full bg-zinc-200 hover:bg-zinc-300 dark:bg-zinc-800 dark:hover:bg-zinc-700 text-zinc-900 dark:text-white font-semibold py-3 px-4 rounded-md transition duration-200 disabled:opacity-50"
            >
              Cancelar
            </button>
          </div>
        </div>
      </main>
    </div>
  );
}