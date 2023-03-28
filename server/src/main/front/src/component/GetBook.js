import React, {useState} from 'react';
import axios from 'axios';

function GetBook() {
    const Url = "http://localhost:8080";

    const [ISBN, setISBN] = useState();
    const [bookName, setBookName] = useState();
    const [author, setAuthor] = useState();
    const [publisher, setPublisher] = useState();

    const bookNameHandler = (e) => {
        e.preventDefault();
        setBookName(e.target.value)
    }

    const ISBNHandler = (e) => {
        e.preventDefault();
        setISBN(e.target.value)
    }

    const authorHandler = (e) => {
        e.preventDefault();
        setAuthor(e.target.value)
    }

    const publisherHandler = (e) => {
        e.preventDefault();
        setPublisher(e.target.value)
    }

    const submitHandler = (e) => {
        e.preventDefault()
        getBook();
    }

    async function getBook() {
        await axios.put(Url + "/api/book/add", {
            isbn:ISBN,
            bookName:bookName,
            author:author,
            publisher:publisher
        })
        .then((response) => {
            console.log(response.data)
        })
        .catch((error) => {
            console.log(error)
        });
    }

    return (
        <form onSubmit={submitHandler}>
                        <h1>책 등록</h1>
                        <label>BookName</label>
                        <input type="text" value={bookName} onChange={bookNameHandler}></input>
                        <label>ISBN</label>
                        <input type="text" value={ISBN} onChange={ISBNHandler}></input>
                        <label>Author</label>
                        <input type="text" value={author} onChange={authorHandler}></input>
                        <label>Publisher</label>
                        <input type="text" value={publisher} onChange={publisherHandler}></input>
                        <br/>
                        <button type="submit">Add</button>
                    </form>
    )
}

export default GetBook;