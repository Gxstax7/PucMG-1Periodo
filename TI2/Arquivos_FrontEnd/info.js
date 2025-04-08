    // Função para capturar o ID da URL
    function obterIdDaUrl() {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get('id');
      }
  
      const id = obterIdDaUrl();
      const url = `https://api.rawg.io/api/games/${id}?key=515e12bfda4d446db7e7f4175b687895`;
  
      async function loadInfo(){
        const resp = await fetch(url);
        if(resp.status === 200){
            const game = await resp.json();
            console.log(game);
            document.querySelector('#conteudo').innerHTML = `${game.name}`;
        }

        

      }
  
      loadInfo();



