'use strict';

const output = document.getElementById("output");

const readAll = async () => {
    const res = await axios.get("/library");
    output.innerHTML = "";
    res.data.forEach(library => renderLibrary(library));
}

const renderLibrary = ({ libID, name, book }) => {
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
    modelText.innerText = `Library Name: ${name}`;
    cardBody.appendChild(modelText);

    const bookText = document.createElement("p");
    bookText.className = "card-text";
    bookText.innerText = `Number of Books: ${numBooks(book)}`;
    cardBody.appendChild(bookText);

    const cardFooter = document.createElement("div");
    cardFooter.className = "card-footer";
    card.appendChild(cardFooter);

    const bookButton = document.createElement("a");
    bookButton.innerText = "Books";
    bookButton.className = "card-link";
    bookButton.addEventListener("click", function () {

        navigate(libID, name);

    });

    cardFooter.appendChild(bookButton);

    // Delete Functionality
    const deleteButton = document.createElement("a");
    deleteButton.innerText = "Delete";
    deleteButton.className = "card-link";
    deleteButton.addEventListener("click", function () {
        removeLibrary(libID);
    });
    cardFooter.appendChild(deleteButton);

    // Update Functionality
    const updateButton = document.createElement("a");
    updateButton.innerText = "Update";
    updateButton.className = "card-link";
    updateButton.addEventListener("click", function () {
        document.getElementById("updateform1").style.display = "inline";
        document.getElementById("updateform1").addEventListener("submit", function (event) {
            event.preventDefault();
            const library = {
                name: this.name.value

            }
            axios.put(`/library/update/${libID}`, library)
                .then(response => {
                    readAll();
                    this.reset();
                    document.getElementById("updateform1").style.display = "none";
                });


        });


    });
    cardFooter.appendChild(updateButton);

    output.appendChild(column);
}

// Delete Functionality
const removeLibrary = async (libID) => {
    const res = await axios.delete(`/library/remove/${libID}`);
    readAll();
}

// Create Functionality
document.getElementById("libform").addEventListener("submit", function (event) {
    event.preventDefault();


    const lib = {

        name: this.newname.value

    }

    axios.post("/library/create", lib)
        .then(response => {
            readAll();
            this.reset();
        }).catch(err => console.log(err));
});

const navigate = (id, name) => {

    window.location.href = `./addbooks.html?id=${id}&name=${name}`;

}

const numBooks = (books) => {
    let count = 0;
    for (let i = 0; i < books.length; i++) {
        count++
    }
    return count;
}




readAll();

