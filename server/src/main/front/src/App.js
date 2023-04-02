import React, {useEffect} from 'react';
import {Link, Route, Switch} from 'react-router-dom';
import ShowBook from './component/ShowBook';
import GetBook from './component/GetBook';

function App() {
    useEffect(()=>{
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

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