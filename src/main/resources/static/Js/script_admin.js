document.addEventListener('DOMContentLoaded', function () {

  function carregaMenu() {
    document.querySelectorAll('.menu-item').forEach(link => {
      link.addEventListener('click', event => {
        event.preventDefault();
        const targetSection = link.getAttribute('data-section');

        document.querySelectorAll('.section-content').forEach(section => {
          section.style.opacity = 0;
          setTimeout(() => {
            section.style.display = 'none';
          }, 300);
        });

        const target = document.getElementById(targetSection);
        setTimeout(() => {
          target.style.display = 'block';
          target.style.opacity = 1;
        }, 300);
      });
    });
  }

  function carregaNome() {
    const userSection = document.getElementById("pagina-principal");
    const nomeUsuario = localStorage.getItem("nomeUsuario");

    const nomeAdmin = `
      <h1 class="mb-4 section-title">Bem-vindo, ${nomeUsuario}</h1>
      <p class="mb-5">Use o menu para gerenciar jogadores, jogos e técnicos.</p>
      <div class="row text-center mb-4">
        <div class="col-md-4">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Total de Jogadores</h5>
              <p class="card-text display-4">50</p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Próximos Jogos</h5>
              <p class="card-text display-4">8</p>
            </div>
          </div>
        </div>
      </div>
    `;
    userSection.innerHTML = nomeAdmin;
  }

  function fetchJogadores() {
    const apiUrlJogadores = 'http://localhost:8080/jogadores';
    fetch(apiUrlJogadores)
      .then(response => {
        if (!response.ok) {
          throw new Error(`Erro na API: ${response.statusText}`);
        }
        return response.json();
      })
      .then(jogadores => {
        const carouselItemsContainer = document.getElementById("cards-jogadores");
        carouselItemsContainer.innerHTML = '';
  
        let currentRow;
        let cardCount = 0;
  
        jogadores.forEach((jogador, index) => {
          if (cardCount % 5 === 0) {
            currentRow = document.createElement('div');
            currentRow.className = 'row g-3 justify-content-center';
            carouselItemsContainer.appendChild(currentRow);
          }
  
          const col = document.createElement('div');
          col.className = 'col-md-2 d-flex align-items-stretch justify-content-center';
  
          const card = `
            <div class="card mx-2" style="width: 100%; height: 100%; border-radius: 10px;">
              <div class="card-body d-flex flex-column align-items-center justify-content-between">
                <div class="d-flex justify-content-between w-100">
                  <button class="btn btn-success btn-sm" onclick="editarJogador(${jogador.id})">Editar</button>
                  <button class="btn btn-danger btn-sm" onclick="excluirJogador(${jogador.id})">Excluir</button>
                </div>
                <img src="http://localhost:8080/${jogador.foto}" class="card-img-top" style="object-fit: contain; height: 150px;" alt="Foto do Jogador">
                <h5 class="card-title fs-5 text-center" style="color: #11C770; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
                  ${jogador.nome}
                </h5>
                <p class="card-text fs-6 mt-2 text-center">
                  <span class="fw-bold">Posição:</span> ${jogador.posicao}
                </p>
                <button class="btn btn-outline-success mt-3" style="width: 100%;">Ver mais</button>
              </div>
            </div>
          `;
  
          col.innerHTML = card;
          currentRow.appendChild(col);
  
          cardCount++;
        });
      })
      .catch(error => {
        console.error("Erro ao carregar os jogadores:", error);
      });
  }
  
  

  function fetchJogos() {
    const apiUrlPartidas = 'http://localhost:8080/partidas';
    fetch(apiUrlPartidas)
      .then(response => {
        if (!response.ok) {
          throw new Error(`Erro na API: ${response.statusText}`);
        }
        return response.json();
      })
      .then(partidas => {
        const carouselItemsContainer = document.getElementById("cards-jogos");
        carouselItemsContainer.innerHTML = '';
  
        let currentRow;
        let cardCount = 0;
  
        partidas.forEach((partida, index) => {
          if (cardCount % 4 === 0) {
            currentRow = document.createElement('div');
            currentRow.className = 'row g-3 justify-content-center'; 
            carouselItemsContainer.appendChild(currentRow);
          }
  
          const jogoCard = `
            <div class="col-3 d-flex align-items-stretch justify-content-center" style="max-width: 300px;"> <!-- Centraliza o conteúdo da coluna -->
              <div class="card mx-2" style="width: 100%; height: auto;">
                <div class="bg-success text-white d-flex justify-content-between px-3 py-2">
                  <!-- Data e Hora -->
                  <span>${new Date(partida.data).toLocaleDateString('pt-BR')}</span>
                  <span>${new Date('1970-01-01T' + partida.hora + 'Z').toLocaleTimeString('pt-BR', { hour: '2-digit', minute: '2-digit' })}</span>
                </div>
                <div class="card-body d-flex flex-column align-items-center justify-content-between bg-light" style="padding-bottom: 10px;">
                  <!-- Imagem do Jogo -->
                  <img src="${partida.foto}" class="card-img-top" style="width: 200px; height: 200px; object-fit: contain;" alt="Foto do jogo ${partida.id}">
                  <h5 class="card-title text-center">${partida.timeadversario}</h5>
                </div>
                <!-- Campeonato -->
                <div class="bg-dark text-white text-center py-2 w-100" style="font-size: 0.9rem;">
                  ${partida.campeonato}
                </div>
              </div>
            </div>
          `;
  
          currentRow.innerHTML += jogoCard;
  
          cardCount++;
        });
      })
      .catch(error => {
        console.error("Erro ao carregar os jogos:", error);
      });
  }

  window.excluirJogador = function(id) {
    Swal.fire({
      title: 'Tem certeza?',
      text: "Essa ação não pode ser desfeita!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#11C770', // Cor do botão de confirmação
      cancelButtonColor: '#d33',    // Cor do botão de cancelar
      confirmButtonText: 'Sim, excluir!',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
        const apiUrlExcluir = `http://localhost:8080/jogadores/${id}`;
  
        fetch(apiUrlExcluir, {
          method: 'DELETE',
        })
          .then(response => {
            if (!response.ok) {
              throw new Error(`Erro ao excluir o jogador: ${response.statusText}`);
            }
            Swal.fire(
              'Excluído!',
              'O jogador foi removido com sucesso.',
              'success'
            );
  
            // Atualizar a lista de jogadores
            fetchJogadores();
          })
          .catch(error => {
            console.error("Erro ao excluir o jogador:", error);
            Swal.fire(
              'Erro!',
              'Não foi possível excluir o jogador. Tente novamente.',
              'error'
            );
          });
      }
    });
  }  
  carregaNome();
  carregaMenu();
  fetchJogadores();
  fetchJogos();
});
