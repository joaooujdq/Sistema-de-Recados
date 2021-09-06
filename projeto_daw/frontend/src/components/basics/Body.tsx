import { useState } from "react";


interface BodyProps{
    msg: string;
    msg_esp?: string;
}


const Body: React.FC<BodyProps> = (props) => { //generics
    const [contador, setContador] = useState(1);
    const [nome, setNome] = useState('');
    
    function ButtonClick1(){
        setContador(contador + 1);
        console.log(contador);
    }

    function ButtonClick2(){
        setNome("fulano");
        console.log(nome);
    }

    return (
        <>
        <h1> {props.msg} </h1>
        <h2>{contador} </h2>
        <button onClick={ButtonClick1}>atualizar</button>
        <button onClick={ButtonClick2}>Nomear</button>
        <h4>{nome}</h4>
        </>
    )
}

export default Body;


