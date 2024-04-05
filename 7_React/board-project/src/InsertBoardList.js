import React, { useState, useContext } from 'react';
import { DataContext } from './App';



const InsertBoardList = ()=>{

    const {data, setData} = useContext(DataContext);

    const [input, setInput] = useState('');

    // 현재 날짜
    const dateFormat = ()=>{
        const date = new Date();
        const month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1;
        const dt = date.getDate();
        if(dt < 10){
            dt = '0' + dt;
        }

        return `${date.getFullYear()}-${month}-${dt}`;
    }

    // 목록 추가
    const insertList = ()=>{
        // 입력이 되었을 때만 새롭게 추가
        if(input !== ''){
            const dataCopy = [ {title: input, writer:'유저일', like:0, issueDate: dateFormat(), content:''}, ...data];
            setData(dataCopy);
            setInput('');

        } else{
            alert("내용을 입력해주세요.");
        }

    }
    return(

        <>
            {/* header */}
            <div className='header'>
                <input value={input} onChange={(e)=>{setInput(e.target.value)}}></input>

                {/* 새로운 글 추가 */}
                <button onClick={ insertList }>추가</button>

                {/* 제목 가나다순으로 정렬 */}
                <button>제목 정렬</button>
            </div>
        </>

    );
}

export default InsertBoardList;