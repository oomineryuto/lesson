//console.log('Hello JavaScript');
fetch(`/api/products`)
.then(res => {
 const column = document.getElementById('product-list')
res.json()
.then(list =>{
for(let i of list){
//console.log(i);
 let tr = document.createElement("tr");
 let idTd =document.createElement("td");
 let nameTd =document.createElement("td");
 let priceTd=document.createElement("td");
 idTd.textContent = i.id;
 tr.appendChild(idTd);
 nameTd.textContent = i.name;
 tr.appendChild(nameTd);
 priceTd.textContent = i.price;
 tr.appendChild(priceTd);
 column.appendChild(tr);
}
})
})
