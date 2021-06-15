'use strict';

const output = document.getElementById("output");

const getLibrary = async () => {
    const res = await axios.get("/library");
    output.innerHTML = "";
    res.data.forEach(library => console.log(library));
    // renderLibrary(library));
}

const renderLibrary = ({ name }) => {
    const column = document.createElement("div");
    column.className = "col";

    const card = document.createElement("div");
    card.className = "card";
    column.appendChild(card);

    const cardBody = document.createElement("div");
    cardBody.className = "card-body";
    card.appendChild(cardBody);

    const makeText = document.createElement("p");
    makeText.className = "card-text";
    makeText.innerText = `Name: ${name}`;
    cardBody.appendChild(makeText);

    const cardFooter = document.createElement("div");
    cardFooter.className = "card-footer";
    card.appendChild(cardFooter);

    const deleteButton = document.createElement("a");
    deleteButton.innerText = "Delete";
    deleteButton.className = "card-link";
    deleteButton.addEventListener("click", function () {
        deleteCar(id);
    });
    cardFooter.appendChild(deleteButton);

    output.appendChild(column);
}

getLibrary();



// document.getElementById("createForm").addEventListener("submit", function (event) {
//     event.preventDefault();

//     const data = {
//         make: this.make.value,
//         model: this.Model.value,
//         colour: this.Colour.value
//     }

//     axios.post("/cars/create", data)
//         .then(res => {
//             getCars();
//             this.reset();
//             this.make.focus();
//         }).catch(err => console.log(err));

//     console.log(this);
// });

// const deleteCar = async (id) => {
//     const res = await axios.delete(`/cars/remove/${id}`);
//     getCars();