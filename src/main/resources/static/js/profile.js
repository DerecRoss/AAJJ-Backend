async function loadProfile() {
      const response = await fetch("/user/api/profile");
      if (!response.ok) {
        alert("Erro ao carregar perfil");
        return;
      }
      const user = await response.json();

      document.getElementById("user-name").textContent = user.name;
      document.getElementById("user-email").textContent = user.email;
      document.getElementById("user-phone").textContent = user.phone;
      document.getElementById("user-age").textContent = user.age;
      document.getElementById("user-belt").textContent = user.belt;
      document.getElementById("user-time").textContent = user.time;
    }
    document.getElementById("logout").addEventListener("click", async () => {
    try {
    const response = await fetch("http://localhost:8080/logout", {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
    });

    if (response.redirected) {
      // Logout feito com sucesso, redirecionado para /login ou /home
      window.location.href = response.url;
    } else {
      alert("Logout falhou.");
    }
  } catch (error) {
    console.error("Erro ao deslogar:", error);
  }
});

document.getElementById("deleteAccountBtn").addEventListener("click", async () => {
  if (!confirm("Tem certeza que deseja excluir sua conta? Essa ação não pode ser desfeita.")) return;

  try {
    const response = await fetch("/user/api/profile", {
      method: "DELETE",
    });

    if (response.ok) {
      alert("Conta excluída com sucesso.");
      window.location.href = "/home";
    } else {
      alert("Erro ao excluir conta.");
    }
  } catch (err) {
    console.error("Erro:", err);
  }
});

loadProfile();