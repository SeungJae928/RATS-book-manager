import React, {useState, useEffect} from 'react';
import axios from 'axios';

function ShowBook() {
    const Url = "http://localhost:8080";

    const [state,setState] = useState(false);

    const [bookList, setBookList] = useState({
        sid:'',
        isbn:'',
        bookname:'',
        author:'',
        publisher:''
    });

    useEffect(() => {
        showBookList()
        // eslint-disable-next-line
    }, [])

    const bookListHandler = (e) => {
        e.preventDefault();
        showBookList();
    }

    async function showBookList() {
        await axios.get(Url + "/api/book/list")
        .then((response) => {
            setBookList(response.data)
        })
        .catch((error) => {
            console.log("error")
            console.log(error)
        });
    }

    return (
            <form onSubmit={bookListHandler}>
                    <h1>책 조회</h1>
                    <button onClick={() => setState(!state)}>{!state ? "조회" : "숨기기"}</button>
                    <br/>
                    <label>BookList</label>
                    <table>
                        <thead>
                        </thead>
                        <tbody>
                        <tr>
                            <th>ISBN</th>
                            <th>BookName</th>
                            <th>Author</th>
                            <th>Publisher</th>
                        </tr>
                            {state && bookList.map((item) => {
                                return (
                                    <tr>
                                        <td>{item.isbn}</td>
                                        <td>{item.bookname}</td>
                                        <td>{item.author}</td>
                                        <td>{item.publisher}</td>
                                        <td><button>대출</button></td>
                                        <td><button>반납</button></td>
                                    </tr>
                                )
                            })}
                        </tbody>
                    </table>
                </form>
    )

}

export default ShowBook;