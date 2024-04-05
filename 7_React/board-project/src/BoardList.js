import React, { useState, useContext } from 'react';
import { DataContext } from './App';
import './css/boardList-style.css';
import { Link, Outlet, useNavigate, useParams } from 'react-router-dom';


const BoardList = ()=>{
    const {data, setData} = useContext(DataContext);
    let index = 0;

    const [modal, setModal] = useState(false);

    /* 선택한 게시글 번호를 기억하기 위한 index */
    const [boardNo, setBoardNo] = useState(0);

    /* 페이지 이동 시 */
    const navigate = useNavigate();

    // useParams() : URL 파라미터에 입력한 데이터를 가지고 옴
    const {boardCode} = useParams();
    console.log(boardCode)

    return(
        <>
            <Link to='insertBoardList' className='secretLink'>게시글 추가</Link>
            {/* nested routes 안에 어디에 보여줄지 지정 */}
            <Outlet/>
            {   
                data.map(function(d, i){
                    return(
                        <div className="list" key={index++}>
                            <div className='content'>
                                <h4 onClick={()=>{(navigate(`/${boardCode}/detail/${i}`))}}>{d.title} 

                                    {/* 좋아요 */}
                                    <span onClick={ e =>{
                                        e.stopPropagation(); // 부모 요소로의 이벤트 전달을 막아주는 함수
                                        const likeCopy = [...data];
                                        likeCopy[i].like++;
                                        setData(likeCopy);
                                    }}>❤️</span> {d.like}
                                    
                                </h4>
                                <p>{d.writer} | {d.issueDate}</p>
                            </div>

                            <div className='board-btn-area'>
                                <button onClick={()=>{
                                    setModal(i === boardNo ? !modal : true)
                                    //setModal(!modal)
                                    setBoardNo(i)
                                }}>모달</button>
                            </div>
                           
                        </div>
                    );
                })
            }

            { modal === true ? <Modal data={data} boardNo={boardNo}/> : null}
        </>
    );
}

/* 모달창 */
const Modal = (props)=>{
    const data = props.data;
    const boardNo = props.boardNo;

    return(
        <div className="modal">
            <h4>{data[boardNo].title}</h4>
            <p>{data[boardNo].writer} | {data[boardNo].issueDate}</p>
            <p>{data[boardNo].content}</p>
        </div>
    );
}

export default BoardList;