document.addEventListener('DOMContentLoaded', function () {

  document.getElementById("logout-btn").addEventListener("click", function (e) {
    e.preventDefault();
    Swal.fire({
        title: 'Tem certeza?',
        text: "Deseja finalizar a seção?!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#11C770',
        cancelButtonColor: '#d33',   
        confirmButtonText: 'Sim, sair!',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            console.log('Logout confirmado');
            localStorage.removeItem("nomeUsuario");
            localStorage.removeItem("tipoUsuario");
            window.location.href = 'http://localhost:8080/usuario/login';
        }
    });
});


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

  function fetchJogadoresEstatistica() {
    const apiUrlJogadores = 'http://localhost:8080/jogadores';
    fetch(apiUrlJogadores)
      .then(response => {
        if (!response.ok) {
          throw new Error(`Erro na API: ${response.statusText}`);
        }
        return response.json();
      })
      .then(jogadores => {
        const carouselItemsContainer = document.getElementById("cards-jogadores-estatistica");
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
                  <button class="btn btn-success btn-sm" onclick="editarJogador(${jogador.id})">Inserir</button>
                  <button class="btn btn-danger btn-sm" onclick="excluirJogador(${jogador.id})">Editar</button>
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
          <div class="col-3 d-flex align-items-stretch justify-content-center" style="max-width: 300px;">
            <div class="card mx-2 shadow-lg" style="width: 100%; height: auto;">
              <div class="bg-success text-white d-flex justify-content-between px-3 py-2">
                <span>${new Date(partida.data).toLocaleDateString('pt-BR')}</span>
                <span>${partida.hora}</span>
              </div>
              <div class="card-body d-flex flex-column align-items-center justify-content-between bg-light" style="padding-bottom: 10px;">
                <img src="http://localhost:8080/${partida.foto}" class="card-img-top" style="width: 200px; height: 200px; object-fit: contain;" alt="Foto do jogo ${partida.id}">
                <h5 class="card-title text-center mt-2">${partida.timeadversario}</h5>
              </div>
              <div class="bg-dark text-white text-center py-2 w-100" style="font-size: 0.9rem;">
                ${partida.campeonato}
              </div>
              <div class="d-flex justify-content-around py-2">
                <button class="btn btn-success btn-sm" style="font-size: 0.8rem;" onclick="editarJogo(${partida.id})">
                  <i class="bi bi-pencil"></i> Editar
                </button>
                <button class="btn btn-danger btn-sm" style="font-size: 0.8rem;" onclick="excluirJogos(${partida.id})">
                  <i class="bi bi-trash"></i> Excluir
                </button>
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

  window.excluirJogos = function(id) {
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
        const apiUrlExcluir = `http://localhost:8080/partidas/${id}`;
  
        fetch(apiUrlExcluir, {
          method: 'DELETE',
        })
          .then(response => {
            if (!response.ok) {
              throw new Error(`Erro ao excluir o jogo: ${response.statusText}`);
            }
            Swal.fire(
              'Excluído!',
              'O jogo foi removido com sucesso.',
              'success'
            );
            fetchJogos();
          })
          .catch(error => {
            console.error("Erro ao excluir o jogo:", error);
            Swal.fire(
              'Erro!',
              'Não foi possível excluir o jogo. Tente novamente.',
              'error'
            );
          });
      }
    });
  } 
  
  window.editarJogador = function (id) {
    const apiUrlJogador = `http://localhost:8080/jogadores/${id}`;
  
    fetch(apiUrlJogador)
      .then(response => {
        if (!response.ok) {
          throw new Error(`Erro ao buscar o jogador: ${response.statusText}`);
        }
        return response.json();
      })
      .then(jogador => {
        // Cria o modal dinamicamente
        const modalContainer = document.createElement('div');
        modalContainer.innerHTML = `
          <div class="modal fade" id="editarJogadorModal" tabindex="-1" aria-labelledby="editarJogadorModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="editarJogadorModalLabel">Editar Jogador: ${jogador.nome}</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <form id="editarJogadorForm">
                    <div class="mb-3">
                      <label for="nome" class="form-label">Nome</label>
                      <input type="text" class="form-control" id="nome" value="${jogador.nome}">
                    </div>
                    <div class="mb-3">
                      <label for="pernaDominante" class="form-label">Perna Dominante</label>
                      <select class="form-select" id="pernaDominante">
                        <option value="direita" ${jogador.pernadominante === 'direita' ? 'selected' : ''}>Direita</option>
                        <option value="esquerda" ${jogador.pernadominante === 'esquerda' ? 'selected' : ''}>Esquerda</option>
                      </select>
                    </div>
                    <div class="mb-3">
                      <label for="posicao" class="form-label">Posição</label>
                      <select class="form-select" id="posicao">
                        <option value="Goleiro" ${jogador.posicao === 'Goleiro' ? 'selected' : ''}>Goleiro</option>
                        <option value="Zagueiro" ${jogador.posicao === 'Zagueiro' ? 'selected' : ''}>Zagueiro</option>
                        <option value="Lateral" ${jogador.posicao === 'Lateral' ? 'selected' : ''}>Lateral</option>
                        <option value="Meio-Campo" ${jogador.posicao === 'Meio-Campo' ? 'selected' : ''}>Meio-Campo</option>
                        <option value="Atacante" ${jogador.posicao === 'Atacante' ? 'selected' : ''}>Atacante</option>
                      </select>
                    </div>
                    <div class="mb-3">
                      <label for="altura" class="form-label">Altura (cm)</label>
                      <input type="text" class="form-control" id="altura" value="${jogador.altura}">
                    </div>
                    <div class="mb-3">
                      <label for="peso" class="form-label">Peso (kg)</label>
                      <input type="text" class="form-control" id="peso" value="${jogador.peso}">
                    </div>
                    <div class="mb-3">
                      <label for="contrato" class="form-label">Contrato</label>
                      <input type="date" class="form-control" id="contrato" value="${jogador.contrato}">
                    </div>
                    <div class="mb-3">
                      <label for="nacionalidade" class="form-label">Nacionalidade</label>
                      <input type="text" class="form-control" id="nacionalidade" value="${jogador.nacionalidade}">
                    </div>
                    <div class="mb-3">
                      <label for="dataNascimento" class="form-label">Data de Nascimento</label>
                      <input type="date" class="form-control" id="dataNascimento" value="${jogador.datanascimento}">
                    </div>
                    <div class="mb-3">
                      <label for="foto" class="form-label">URL da Foto</label>
                      <input type="url" class="form-control" id="foto" value="${jogador.foto}">
                    </div>
                  </form>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                  <button type="button" class="btn btn-success" id="salvarAlteracoes">Salvar</button>
                </div>
              </div>
            </div>
          </div>
        `;
  
        document.body.appendChild(modalContainer);
  
        // Inicializa o modal
        const modal = new bootstrap.Modal(document.getElementById('editarJogadorModal'));
        modal.show();
  
        // Adiciona evento para salvar alterações
        document.getElementById('salvarAlteracoes').addEventListener('click', () => {
          const nome = formatarTexto(document.getElementById('nome').value.trim());
          const pernadominante = document.getElementById('pernaDominante').value.toLowerCase();
          const posicao = document.getElementById('posicao').value;
          const altura = parseFloat(document.getElementById('altura').value.trim().replace(',', '.'));
          const peso = parseFloat(document.getElementById('peso').value.trim().replace(',', '.'));
          const contrato = formatarData(document.getElementById('contrato').value);
          const nacionalidade = formatarTexto(document.getElementById('nacionalidade').value.trim());
          const datanascimento = formatarData(document.getElementById('dataNascimento').value);
          let foto = document.getElementById('foto').value.trim();
          if (!foto) foto = "image/jogadorDesconhecido.jpg";
  
          const jogadorAtualizado = {
            nome,
            pernadominante,
            posicao,
            altura,
            peso,
            contrato,
            nacionalidade,
            datanascimento,
            foto
          };
  
          const apiUrlUpdate = `http://localhost:8080/jogadores/${id}`;
          fetch(apiUrlUpdate, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(jogadorAtualizado)
          })
            .then(response => response.text())
            .then(message => {
              if (message === "Jogador atualizado com sucesso") {
                Swal.fire('Sucesso!', 'Jogador atualizado com sucesso!', 'success');
                modal.hide();
                fetchJogadores();
              } else {
                Swal.fire('Erro!', message, 'error');
              }
            })
            .catch(error => {
              console.error("Erro ao atualizar jogador:", error);
              Swal.fire('Erro!', 'Houve um problema ao salvar as alterações.', 'error');
            });
        });

        document.getElementById('editarJogadorModal').addEventListener('hidden.bs.modal', () => {
          modalContainer.remove();
        });
      })
      .catch(error => {
        console.error("Erro ao carregar jogador:", error);
      });
  };

  window.editarJogo = function (id) {
    const apiUrlJogo = `http://localhost:8080/partidas/${id}`;

    fetch(apiUrlJogo)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Erro ao buscar o jogo: ${response.statusText}`);
            }
            return response.json();
        })
        .then(jogo => {
            const modalContainer = document.createElement('div');
            modalContainer.innerHTML = `
                <div class="modal fade" id="editarJogoModal" tabindex="-1" aria-labelledby="editarJogoModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="editarJogoModalLabel">Editar Jogo: ${jogo.campeonato}</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form id="editarJogoForm">
                                    <div class="mb-3">
                                        <label for="timeadversario" class="form-label">Nome do Time Adversário</label>
                                        <input type="text" class="form-control" id="timeadversario" value="${jogo.timeadversario}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="campeonato" class="form-label">Campeonato</label>
                                        <input type="text" class="form-control" id="campeonato" value="${jogo.campeonato}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="data" class="form-label">Data do Jogo</label>
                                        <input type="date" id="data" class="form-control" value="${jogo.data}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="hora" class="form-label">Hora do Jogo</label>
                                        <input type="time" id="hora" class="form-control" value="${jogo.hora}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="foto" class="form-label">Foto (URL)</label>
                                        <input type="url" id="foto" class="form-control" value="${jogo.foto || ''}">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-success" id="salvarAlteracoesJogo">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            `;

            document.body.appendChild(modalContainer);

            const modal = new bootstrap.Modal(document.getElementById('editarJogoModal'));
            modal.show();

            document.getElementById('salvarAlteracoesJogo').addEventListener('click', () => {
                const timeadversario = formatarTexto(document.getElementById('timeadversario').value);
                const campeonato = formatarTexto(document.getElementById('campeonato').value);
                const data = formatarData(document.getElementById('data').value);
                const hora = document.getElementById('hora').value;
                const foto = document.getElementById('foto').value.trim() || 'image/jogoDesconhecido.jpg';

                const jogoAtualizado = {
                    timeadversario,
                    campeonato,
                    data,
                    hora,
                    foto
                };

                const apiUrlUpdate = `http://localhost:8080/partidas/${id}`;
                fetch(apiUrlUpdate, {
                    method: "PUT",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(jogoAtualizado)
                })
                    .then(response => response.text())
                    .then(message => {
                        if (message === "Partida atualizado com sucesso") {
                            Swal.fire('Sucesso!', 'Jogo atualizado com sucesso!', 'success');
                            modal.hide();
                            fetchJogos(); 
                        } else {
                            Swal.fire('Erro!', message, 'error');
                        }
                    })
                    .catch(error => {
                        console.error("Erro ao atualizar jogo:", error);
                        Swal.fire('Erro!', 'Houve um problema ao salvar as alterações.', 'error');
                    });
            });

            // Remove o modal do DOM após ser fechado
            document.getElementById('editarJogoModal').addEventListener('hidden.bs.modal', () => {
                modalContainer.remove();
            });
        })
        .catch(error => {
            console.error("Erro ao carregar jogo:", error);
        });
};

  
  // Funções auxiliares:
  function formatarTexto(texto) {
    return texto.charAt(0).toUpperCase() + texto.slice(1).toLowerCase();
  }
  
  function formatarData(data) {
    const partes = data.split("-");
    if (partes.length === 3) {
      return `${partes[0]}-${partes[1]}-${partes[2]}`;
    }
    return data;
  }
  
  carregaNome();
  carregaMenu();
  fetchJogadores();
  fetchJogos();
  fetchJogadoresEstatistica()
});
