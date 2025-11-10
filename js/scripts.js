 function entrar() {
      const nome = document.getElementById("nomeCadastro").value.trim();
      const email = document.getElementById("emailCadastro").value.trim();
      const profissao = document.getElementById("profissaoCadastro").value.trim();
      const senha = document.getElementById("senhaCadastro").value.trim();

      if (!nome || !email || !profissao || !senha) {
        alert("Preencha todos os campos!");
        return;
      }

      document.getElementById("telaCadastro").style.display = "none";
      document.getElementById("painel").style.display = "block";
      document.getElementById("nomeUsuarioPerfil").textContent = nome;
      document.getElementById("profissaoUsuarioPerfil").textContent = profissao;
      document.getElementById("nomeUsuarioPost").textContent = nome;
    }

    function mostrar(secao) {
      document.querySelectorAll("section").forEach(s => s.classList.remove("active"));
      document.getElementById(secao).classList.add("active");
    }

    const feed = document.getElementById("feed");

    function publicarPost() {
      const texto = document.getElementById("postText").value.trim();
      const imagem = document.getElementById("uploadMedia").files[0];

      if (texto === "" && !imagem) {
        alert("Escreva algo ou adicione uma imagem antes de publicar.");
        return;
      }

      const novoPost = document.createElement("div");
      novoPost.classList.add("post");

      let imagemHTML = "";
      if (imagem) {
        const imgURL = URL.createObjectURL(imagem);
        imagemHTML = `<img src="${imgURL}" alt="Imagem do post">`;
      }

      const nome = document.getElementById("nomeUsuarioPost").textContent;
      novoPost.innerHTML = `
        <div class="post-info">
          <img src="https://i.pravatar.cc/100?img=12" alt="Usuário">
          <span>${nome}</span>
        </div>
        <div class="post-content">
          <p>${texto}</p>
          ${imagemHTML}
        </div>
        <div class="post-buttons">
          <button>❤️ Curtir</button>
          <button>💬 Comentar</button>
          <button>🔁 Compartilhar</button>
        </div>
      `;

      feed.prepend(novoPost);
      document.getElementById("postText").value = "";
      document.getElementById("uploadMedia").value = "";
    }

    function buscar() {
      const termo = document.getElementById("campoBusca").value.trim();
      const resultado = document.getElementById("resultadoBusca");

      if (termo === "") {
        resultado.innerHTML = "<p>Digite algo para pesquisar.</p>";
        return;
      }

      resultado.innerHTML = `
        <div class="user-card">
          <div class="user-info">
            <img src="https://i.pravatar.cc/100?img=45" alt="Usuário">
            <div>@${termo.toLowerCase().replace(" ", "_")}</div>
          </div>
          <button class="follow-btn">Conectar</button>
        </div>
      `;
    }