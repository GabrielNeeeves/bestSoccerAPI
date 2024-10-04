// LOGIN //
const btnEntrar = document.getElementById("btnEntrar");
const usuarioNome = document.getElementById("usuarioNome");
const usuarioEmail = document.getElementById("usuarioEmail");
const usuarioSenha = document.getElementById("usuarioSenha");

//CADASTRO
const btnCadastrar = document.getElementById("btnCadastrar");
const cadastroNome = document.getElementById("cadastroNome");
const cadastroEmail = document.getElementById("cadastroEmail");
const cadastroSenha = document.getElementById("cadastroSenha");

// FUNÇÃO MANDAR DADOS DO LOGIN PARA A API //
// function login() {

//     fetch("http://localhost:8080/usuarios",     //url da API
//     {
//         headers: {
//             'Accept': 'application/json',
//             'Content-Type': 'application/json'
//         },
//         method: "POST",
//         body: JSON.stringify({
//             nome: usuarioNome.value,
//             email: usuarioEmail.value,
//             senha: usuarioSenha.value
//         })
//     })
//     .then(function (res) {console.log(res)})
//     .catch(function (res) {console.log(res)})
// };

function limparCampos() {
    usuarioNome.value = "";
    usuarioEmail.value = "";
    usuarioSenha.value = "";

    cadastroNome.value = "";
    cadastroEmail.value = "";
    cadastroNome.value = "";
}

btnEntrar.addEventListener('click', function(event) {

    if(usuarioNome.value === "" | usuarioEmail.value === "" || usuarioSenha === "") {
        event.preventDefault();
        window.alert('Um ou mais campo(s) vazio(s)');
        
    } else {
    // login();
    limparCampos();
    }

});


// FUNÇÃO MANDAR DADOS DO CADASTRO PARA A API //
// function cadastroAdmin() {

//     fetch("http://localhost:8080/admins",     //url API
//     {
//         headers: {
//             'Accept': 'application/json',
//             'Content-Type': 'application/json'
//         },
//         method: "POST",
//         body: JSON.stringify({
//             nome: cadastroNome.value,
//             email: cadastroEmail.value,
//             senha: cadastroSenha.value
//         })
//     })
//     .then(function (res) {console.log(res)})
//     .catch(function (res) {console.log(res)})
// };

btnCadastrar.addEventListener('click', function(event) {

    
});