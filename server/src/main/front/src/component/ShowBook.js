import React, {useState} from 'react';
import axios from 'axios';

function ShowBook() {
    const Url = "http://localhost:8080";

    const [bookList, setBookList] = useState();

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
            console.log(error)
        });
    }

    return (
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
    )

}

export default ShowBook;