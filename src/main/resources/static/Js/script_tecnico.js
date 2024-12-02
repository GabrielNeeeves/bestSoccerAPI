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
    const userSection = document.getElementById("pagina-principal-tecnico");
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
                </div>
                <img src="http://localhost:8080/${jogador.foto}" class="card-img-top" style="object-fit: contain; height: 150px;" alt="Foto do Jogador">
                <h5 class="card-title fs-5 text-center" style="color: #11C770; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
                  ${jogador.nome}
                </h5>
                <p class="card-text fs-6 mt-2 text-center">
                  <span class="fw-bold">Posição:</span> ${jogador.posicao}
                </p>
                <button class="btn btn-outline-success mt-3" style="width: 100%" onclick="mostrarModal(${jogador.id})">Ver mais</button>
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

window.mostrarModal = function(id) {
    const modalContainer = document.getElementById("modal-container-jogadores") || document.createElement('div');
    modalContainer.id = "modal-container-jogadores";
    document.body.appendChild(modalContainer);

    fetch(`http://localhost:8080/jogadores/${id}`)
        .then(response => response.json())
        .then(jogador => {
            fetch(`http://localhost:8080/estatisticas-jogador/${id}`)
                .then(response => response.json())
                .then(estatisticas => {
                    const modalContent = `
                        <div class="modal fade" id="playerModal" tabindex="-1" aria-labelledby="playerModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header border-0">
                                        <h5 class="modal-title fs-3 text-center text-success" id="playerModalLabel">${jogador.nome}</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body p-4">
                                        <div class="row">
                                            <div class="col-md-4 mb-4 d-flex justify-content-center">
                                                <img src="http://localhost:8080/${jogador.foto}" class="img-fluid rounded-circle border" alt="Foto do Jogador" style="max-width: 150px; max-height: 150px; object-fit: cover;">
                                            </div>
                                            <div class="col-md-8">
                                                <p><strong>Posição:</strong> ${jogador.posicao}</p>
                                                <p><strong>Pé Dominante:</strong> ${jogador.pernadominante}</p>
                                                <p><strong>Contrato:</strong> ${new Date(jogador.contrato).toLocaleDateString('pt-BR')}</p>
                                                <p><strong>Nacionalidade:</strong> ${jogador.nacionalidade}</p>
                                                <p><strong>Data de Nascimento:</strong> ${new Date(jogador.datanascimento).toLocaleDateString('pt-BR')}</p>

                                                <h6 class="mt-4 text-success"><strong>Estatísticas:</strong></h6>
                                                <table class="table table-striped table-bordered">
                                                    <tbody>
                                                        <tr>
                                                            <td><strong>Jogos Jogados</strong></td>
                                                            <td>${estatisticas.jogosdisputados}</td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Gols Marcados</strong></td>
                                                            <td>${estatisticas.golsmarcados}</td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Assistências</strong></td>
                                                            <td>${estatisticas.assistencias}</td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Chutes</strong></td>
                                                            <td>${estatisticas.finalizacoes}</td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Passes</strong></td>
                                                            <td>${estatisticas.passes}</td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Desarmes</strong></td>
                                                            <td>${estatisticas.desarmes}</td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Faltas</strong></td>
                                                            <td>${estatisticas.faltascometidas}</td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Cartões Amarelos</strong></td>
                                                            <td>${estatisticas.cartoesamarelos}</td>
                                                        </tr>
                                                        <tr>
                                                            <td><strong>Cartões Vermelhos</strong></td>
                                                            <td>${estatisticas.cartoesvermelhos}</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    `;
                    modalContainer.innerHTML = modalContent;
                    const modal = new bootstrap.Modal(document.getElementById('playerModal'));
                    modal.show();
                })
                .catch(error => console.error("Erro ao buscar estatísticas do jogador:", error));
        })
        .catch(error => console.error("Erro ao buscar informações do jogador:", error));
}


  fetchJogadores();
  carregaMenu();
  carregaNome();

});