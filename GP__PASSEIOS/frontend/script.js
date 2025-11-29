const API = "http://localhost:8080/api";


async function carregarTours(){
const res = await fetch(`${API}/tours`);
const tours = await res.json();


document.querySelector('#tours').innerHTML =
tours.map(t => `
<div class="tour-card">
<h3>${t.title}</h3>
<p>${t.location} — R$ ${t.price}</p>
<button onclick="detalhes(${t.id})">Ver detalhes</button>
</div>
`).join('');
}


async function detalhes(id){
const res = await fetch(`${API}/tours/${id}`);
const t = await res.json();


document.querySelector('#details').innerHTML = `
<h2>${t.title}</h2>
<p>${t.description}</p>
<button onclick="reservar(${t.id})">Reservar</button>
`;
}


function reservar(id){
document.querySelector('#booking').innerHTML = `
<h3>Reserva</h3>
<input id="nome" placeholder="Seu nome"><br>
<input id="email" placeholder="Email"><br>
<input id="date" placeholder="2025-12-01"><br>
<button onclick="enviarReserva(${id})">Enviar</button>
`;
}


async function enviarReserva(id){
const data = {
clientName: document.querySelector('#nome').value,
clientEmail: document.querySelector('#email').value,
date: document.querySelector('#date').value,
tour: { id }
};


await fetch(`${API}/bookings`,{
method:'POST',
headers:{'Content-Type':'application/json'},
body:JSON.stringify(data)
});


alert('Reserva enviada!');
}


carregarTours();