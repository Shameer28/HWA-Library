'use strict';

const output = document.getElementById("output");

const readAll = async () => {
    const res = await axios.get("/books/create");
    output.innerHTML = "";
    res.data.forEach(book => renderBooks(book));
}

const renderBooks = ({ bookID, name, author }) => {
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
    makeText.innerText = `bookID: ${bookID}`;
    cardBody.appendChild(makeText);

    const modelText = document.createElement("p");
    modelText.className = "card-text";
    modelText.innerText = `name: ${name}`;
    cardBody.appendChild(modelText);

    const colourText = document.createElement("p");
    colourText.className = "card-text";
    colourText.innerText = `author: ${author}`;
    cardBody.appendChild(colourText);

    const cardFooter = document.createElement("div");
    cardFooter.className = "card-footer";
    card.appendChild(cardFooter);

    const deleteButton = document.createElement("a");
    deleteButton.innerText = "Delete";
    deleteButton.className = "card-link";
    deleteButton.addEventListener("click", function () {
        // deleteCar(id);
    });
    cardFooter.appendChild(deleteButton);

    output.appendChild(column);
}

readAll();

