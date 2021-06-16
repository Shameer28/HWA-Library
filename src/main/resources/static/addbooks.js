'use strict';
const currtlibID = new URLSearchParams(window.location.search).get("id");
const currtlibName = new URLSearchParams(window.location.search).get("name");

const output = document.getElementById("output");

const readAll = async () => {
    const res = await axios.get(`/library/findId/${currtlibID}`);
    output.innerHTML = "";
    res.data.book.forEach(book => renderBooks(book));

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

    // Delete Functionality
    const deleteButton = document.createElement("a");
    deleteButton.innerText = "Delete";
    deleteButton.className = "card-link";
    deleteButton.addEventListener("click", function () {
        removeBooks(bookID);
    });
    cardFooter.appendChild(deleteButton);

    // Update Functionality
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
                    libID: currtlibID,
                    name: currtlibName
                }

            }
            axios.put(`/books/update/${bookID}`, book)
                .then(response => {
                    readAll();
                    this.reset();
                    document.getElementById("updateform").style.display = "none";
                });


        });


    });
    cardFooter.appendChild(updateButton);

    output.appendChild(column);
}

// Delete Functionality
const removeBooks = async (bookID) => {
    const res = await axios.delete(`/books/remove/${bookID}`);
    readAll();
}

// Create Functionality
document.getElementById("libform").addEventListener("submit", function (event) {
    event.preventDefault();


    const book = {
        name: this.name.value,
        author: this.author.value,
        library: {
            libID: currtlibID,
            name: currtlibName
        }

    }

    axios.post("/books/create", book)
        .then(response => {
            readAll();
            this.reset();
        });
});


readAll();


