'use strict';

const output = document.getElementById("output");

const readAll = async () => {
    const res = await axios.get("/books");
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

    const modelText = document.createElement("p");
    modelText.className = "card-text";
    modelText.innerText = `Book Name: ${name}`;
    cardBody.appendChild(modelText);

    const colourText = document.createElement("p");
    colourText.className = "card-text";
    colourText.innerText = `Author: ${author}`;
    cardBody.appendChild(colourText);

    const cardFooter = document.createElement("div");
    cardFooter.className = "card-footer";
    card.appendChild(cardFooter);

    const deleteButton = document.createElement("a");
    deleteButton.innerText = "Delete";
    deleteButton.className = "card-link";
    deleteButton.addEventListener("click", function () {
        removeBooks(bookID);
    });
    cardFooter.appendChild(deleteButton);

    const updateButton = document.createElement("a");
    updateButton.innerText = "Update";
    updateButton.className = "card-link";
    updateButton.addEventListener("click", function () {
        document.getElementById("updateform").style.display = "inline";
        document.getElementById("updateform").addEventListener("submit", function (event) {
            event.preventDefault();
            const book = {
                name: this.name.value,
                author: this.author.value,
                library: {
                    libID: 1,
                    name: "Birch Library"
                }

            }
            axios.put(`/books/update/${bookID}`, book)
                .then(response => {
                    readAll();
                    this.reset();
                    document.getElementById("updateform").style.display = "none";
                });


        });




        // removeBooks(bookID);

    });
    cardFooter.appendChild(updateButton);

    output.appendChild(column);
}
const removeBooks = async (bookID) => {
    const res = await axios.delete(`/books/remove/${bookID}`);
    readAll();
}

document.getElementById("libform").addEventListener("submit", function (event) {
    event.preventDefault();

    console.log(this.name.value);
    console.log(this.author.value);

    const book = {
        name: this.name.value,
        author: this.author.value,
        library: {
            libID: 1,
            name: "Birch Library"
        }

    }
    console.log(book);
    axios.post("/books/create", book)
        .then(response => {
            readAll();
            this.reset();
        });
});


readAll();


