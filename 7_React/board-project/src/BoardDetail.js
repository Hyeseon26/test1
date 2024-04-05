import React, { useState, useContext } from 'react';
import { DataContext } from './App';
import { useParams, useNavigate } from 'react-router-dom';
import './css/boardDetail-style.css'

const BoardDetail = ()=>{
    const {data, setData} = useContext(DataContext);

    // useParams() : URL 파라미터에 입력한 데이터를 가지고 옴
    const {boardNo} = useParams();

    const navigate = useNavigate();

    return(
        <>
            {/* 게시글이 존재하는 경우 */}
            
            <div className="board-detail">  
                {/* 제목 */}
                <h1 className="board-title">{data[boardNo].title}  </h1>


                {/* 작성자 + 좋아요수 */}
                <div className="board-header">
                    <div className="board-writer">
                    <span>{data[boardNo].writer}</span>
                    <span>❤️{data[boardNo].like}</span>
                    </div>


                    <div className="board-info">
                        <p> <span>작성일</span> {data[boardNo].issueDate} </p>    
                        <p> <span>수정일</span> {data[boardNo].issueDate} </p>    
                    </div>
                </div>


                {/* 내용 */}
                <div className="board-content">{data[boardNo].content}</div>


                <div className="board-btn-area">
                        <button >수정</button>
                        <button>삭제</button>

                    <button onClick={()=>{navigate(-1)}}>목록으로</button>
                </div>
            </div>
        </>
    );

}


export default BoardDetail;