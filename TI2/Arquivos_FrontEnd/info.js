function obterIdDaUrl() {
  const urlParams = new URLSearchParams(window.location.search);
  return urlParams.get('id');
}

const id = obterIdDaUrl();


const url = `https://api.rawg.io/api/games/${id}?key=515e12bfda4d446db7e7f4175b687895`;
const screen = `https://api.rawg.io/api/games/${id}/screenshots?key=515e12bfda4d446db7e7f4175b687895`;

async function loadInfo(){
  const resp = await fetch(url);
  const respScreen = await fetch (screen);

  if (respScreen.status === 200) {
    const data = await respScreen.json();
    const screenshotsContainer = document.querySelector('#game-screenshots');
  
    data.results.slice(0, 5).forEach(screenshot => {
      const img = document.createElement('img');
      img.src = screenshot.image;
      img.alt = 'Screenshot do jogo';
      img.style.padding = '10px';
      img.classList.add('screenshot-img');
      screenshotsContainer.appendChild(img);
    });
  }else{

  }

  if(resp.status === 200){
    const game = await resp.json();
    
    // Preenche os dados na página
    document.querySelector('#game-name').textContent = game.name;
    document.querySelector('#game-description').innerHTML = game.description || 'Sem descrição disponível.';
    document.querySelector('#game-image').src = game.background_image;
    document.querySelector('#game-platforms').textContent = game.platforms.map(p => p.platform.name).join(', ');
    document.querySelector('#game-release-date').textContent = game.released || 'Data não informada';
    document.querySelector('#game-rating').textContent = `${game.rating} / 5`;
  } else {
    document.querySelector('#game-name').textContent = 'Jogo não encontrado';
  }
}

loadInfo();
