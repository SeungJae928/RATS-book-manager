import React, {useEffect, useState} from 'react';
import {Link, Route, Switch} from 'react-router-dom';
import axios from 'axios';
import ShowBook from './component/ShowBook';
import GetBook from './component/GetBook';

function App() {
    const Url = "http://localhost:8080";

    // const [ISBN, setISBN] = useState();
    // const [bookName, setBookName] = useState();
    // const [author, setAuthor] = useState();
    // const [publisher, setPublisher] = useState();

    useEffect(()=>{
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    

    // const bookNameHandler = (e) => {
    //     e.preventDefault();
    //     setBookName(e.target.value)
    // }

    // const ISBNHandler = (e) => {
    //     e.preventDefault();
    //     setISBN(e.target.value)
    // }

    // const authorHandler = (e) => {
    //     e.preventDefault();
    //     setAuthor(e.target.value)
    // }

    // const publisherHandler = (e) => {
    //     e.preventDefault();
    //     setPublisher(e.target.value)
    // }

    // const submitHandler = (e) => {
    //     e.preventDefault()
    //     getBook();
    // }

    // async function getBook() {
    //     await axios.put(Url + "/api/book/add", {
    //         isbn:ISBN,
    //         bookName:bookName,
    //         author:author,
    //         publisher:publisher
    //     })
    //     .then((response) => {
    //         console.log(response.data)
    //     })
    //     .catch((error) => {
    //         console.log(error)
    //     });
    // }

    return (
        <div>
            <Switch>
                <Route exact path="/">
                    <div>
                        <h1>도서 관리 시스템</h1>
                        <Link to="/api/book/add">
                            <button>책 등록</button>
                        </Link>
                        <Link to="/api/book/list">
                            <button>책 목록 조회</button>
                        </Link>
                    </div>
                </Route>
                <Route path="/api/book/add">
                    <GetBook/>
                </Route>
                <Route path="/api/book/list">
                    <ShowBook/>
                </Route>
            </Switch>
        </div>
    )
}

export default App;