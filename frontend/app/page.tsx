import { Navbar } from "@/components/navbar";

export default function Home() {
  return (
    <div className="flex min-h-screen flex-col bg-zinc-50 dark:bg-black font-sans">
      <Navbar />
      <main className="flex flex-1 items-center justify-center p-4">
        <h1>Coming soon Home Page.</h1>
      </main>
    </div>
  );
}
