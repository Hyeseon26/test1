import './App.css';
import logo from './images/logo.jpg';
import {Routes, Route, Link} from 'react-router-dom';
import MainContent from './MainContent';
import React, { createContext, useState } from 'react';
import BoardList from './BoardList';
import InsertBoardList from'./InsertBoardList';
import BoardDetail from './BoardDetail';

export const DataContext = createContext(); // 전역변수 생성


function App() {

    const [data, setData] = useState([
        {title : "프로젝트 조원이 안나올 때 꿀팁!", writer : '유저일', like : 0, issueDate : '2024-03-15', content : '안알려줌' },
        {title : "리액트 마스터 하는 법", writer : '유저이', like : 0, issueDate : '2024-03-16', content : '이해될 때까지 복습'},
        {title : "바디프로필 100일만에 찍는 법", writer : '유저삼', like : 0, issueDate : '2024-03-17', content : '덜먹고 더운동하기'},
    ])
  return (
    <DataContext.Provider value={ {data, setData} }>
      <main>
          <header>
              <section>
                  <Link to="/">
                      <img src={logo} id="homeLogo"/>
                  </Link>
              </section>

              <section></section>
              <section></section>
          </header>

          <nav>
              <ul>
                  <li><Link to="/0">공지사항</Link></li>
                  <li><Link to="/1">자유 게시판</Link></li>
                  <li><Link to="/2">질문 게시판</Link></li>
                  <li><Link to="/3">FAQ</Link></li>
                  <li><Link to="/4">1:1문의</Link></li>
              </ul>
          </nav>

          
          <Routes>
            {/* 
              :URL 
              path : 요청 주소 작성
              element : 보여질 화면
            */}
            
            {/* 메인화면 */}
            <Route path="/" element={<MainContent/>}/>

            {/* 게시글 목록 */}
            <Route path="/:boardCode" element={<BoardList/>}>
              {/* nested routs : 중첩으로 route 작성 
                  -> Outlet 태그를 이용하여 보여지게 될 위치 지정 */}

              {/* 게시글 목록 추가 */}
              <Route path="insertBoardList" element={<InsertBoardList />} />
            
            </Route>

            {/* 게시글 상세화면 */}
            <Route path='/:boardCode/detail/:boardNo' element={ <BoardDetail />}/>

            {/* 잘못된 요청일 경우 */}
            <Route path="*" element={<div className='error-page'>존재하지 않는 페이지입니다.</div>} />


          </Routes>
         
      </main>
    </DataContext.Provider>
  );
}

export default App;
