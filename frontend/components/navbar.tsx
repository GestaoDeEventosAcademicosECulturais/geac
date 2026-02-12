import Link from "next/link";


export function Navbar() {
  return (
    <nav className="w-full bg-blue-600 text-white p-4 position-fixed top-0 left-0 z-10">
      <div className="container mx-auto flex items-center justify-between">
        <div className="text-lg font-bold">GEAC</div>
        <div>
          <Link href="/" className="px-3 py-2 hover:bg-blue-700 rounded">
            Home
          </Link>
          <Link href="/signin" className="px-3 py-2 hover:bg-blue-700 rounded">
            Entrar
          </Link>
          <Link href="/signup" className="px-3 py-2 hover:bg-blue-700 rounded">
            Registrar
          </Link>
          <Link href="/logout" className="px-3 py-2 hover:bg-blue-700 rounded">
            Sair
          </Link>
        </div>
      </div>
    </nav>
  );
}