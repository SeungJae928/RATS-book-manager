import React, {useEffect, useState} from 'react';
import {Link, Route, Switch} from 'react-router-dom';
import axios from 'axios';

function App() {
    const Url = "http://localhost:8080";

    const [ISBN, setISBN] = useState();
    const [bookName, setBookName] = useState();
    const [author, setAuthor] = useState();
    const [publisher, setPublisher] = useState();
    const [bookList, setBookList] = useState();

    useEffect(()=>{
        getBook();
        showBookList();
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    

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

    const bookListHandler = (e) => {
        e.preventDefault();
        showBookList();
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

    async function showBookList() {
        await axios.get(Url + "/api/book/list")
        .then((response) => {
            setBookList(response.data)
        })
        .catch((error) => {
            console.log(error)
        });
    }

    return (
        <div>
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
        <form onSubmit={bookListHandler}>
        <h1>책 조회</h1>
            <button type="submit">조회</button>
            <br/>
            <label>BookList</label>
            <table>
                <thead>
                <tr>
                    <th>sid</th>
                    <th>ISBN</th>
                    <th>BookName</th>
                    <th>Author</th>
                    <th>Publisher</th>
                </tr>
                </thead>
                <tbody>
                    {bookList.map((item) => {
                        return(
                            <tr>
                                <td>{item.sid}</td>
                                <td>{item.isbn}</td>
                                <td>{item.bookname}</td>
                                <td>{item.author}</td>
                                <td>{item.publisher}</td>
                            </tr>
                        )
                    })}
                </tbody>
            </table>
        </form>
        </div>
    )
}

export default App;