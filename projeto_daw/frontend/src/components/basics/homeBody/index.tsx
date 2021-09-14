
import {  useEffect, useState } from "react";
import api from "../../../services/api";
import { FiArrowLeft, FiArrowRight } from "react-icons/fi";
import './index.css'
import { Table } from 'react-bootstrap'


interface imensagem {

    codigo_rec: number,
    empresa_rec: string,
    status_rec: string,
    prioridade_rec: string,
    setor_rec: string,
    mensagem_rec: string,
    funcionario: ifuncionario,
    empresa: iempresa,
    _links: i_links,
    tipo_rec: string
}

interface ifuncionario {
    codigo_func: number;
    nome_func: string;
    cargo_func: string;
    login_func: string;
    senha_func: string;
    tipo_func: string;
}
interface iempresa {
    codigo_emp: number,
    nome_emp: string,
    razao_emp: string,
    cnpj_emp: string,
    endereco_emp: string,
    telefone_emp: string
}

interface i_links {
    self: iself
}

interface iself {
    href: string
}

const HomeBody: React.FC = () => {
    const [Msg, setMsg] = useState<imensagem[]>([]);
    const [page, setPage]= useState(0);


    /* const [data,setData]  = useState({
        data: [],
        loaded: false,
        placeholder: 'Loading' 
     });
 
     // Fetch and update date
     useEffect(() => {
         fetch('http://localhost:8000/api/lead/')
         .then(response => {
             if (response.status !== 200) {
                 throw new Error(response.statusText); // Goto catch block
             }
             return response.json(); // <<- Return the JSON Object
         })
         .then(result => {
            console.log(data);
            setData(oldState => ({ ...oldState, data: result})); // <<- Merge previous state with new data
         })
         .catch(error => { // Use .catch() to catch exceptions. Either in the request or any of your .then() blocks
             console.error(error); // Log the error object in the console.
             const errorMessage = 'Something went wrong';
             setData(oldState=> ({ ...oldState, placeholder: errorMessage }));
         });
 
     
  */

    /*  imensagem:{
        codigo_rec: 0,
        empresa_rec: '',
        status_rec: '',
        prioridade_rec: '',
        setor_rec: '',
        mensagem_rec: '',
        funcionario: {
            codigo_func: 0,
            nome_func: '',
            cargo_func: '',
            login_func: '',
            senha_func: '',
            tipo_func: ''
        },
        empresa: {
            codigo_emp: 0,
            nome_emp: '',
            razao_emp: '',
            cnpj_emp: '',
            endereco_emp: '',
            telefone_emp: ''
        },
        _links: {
            self: {
                href: ''
            }

        },
        tipo_rec: ''
    
} */

    async function loadMsg() {
        const response = api.get('/v1/elx/recados/',{params:{page:page,limit:3}});
        setMsg((await response).data._embedded.recadoDTOList);

     
    }

    useEffect(()=>{
        loadMsg()
    },[page]);

   /*  useEffect(() => {

        const response = api.get('/v1/elx/recados/3')
            .then(response => {
                if (response.status !== 200) {
                    throw new Error(response.statusText); // Goto catch block
                }
                return response.data;
            })
            .then(result => {

                //console.log(props);
                console.log(result);
                setMsg(result);
                // <<- Merge previous state with new data
                //console.log(props);
            })
            .catch(error => { // Use .catch() to catch exceptions. Either in the request or any of your .then() blocks
                console.error(error); // Log the error object in the console.
                const errorMessage = 'Something went wrong';
                setMsg(oldState => ({ ...oldState, placeholder: errorMessage }));
            });



    }, []);
 */


    return (

        <>
            <Table striped bordered hover className="text-center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome da Empresa</th>
                        <th>Status</th>
                        <th>Operador</th>
                        <th>Setor</th>
                        <th>Prioridade</th>
                        <th>Mensagem</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        Msg.map(m => (
                            <tr key={m.empresa.nome_emp}>
                                <td>{m.status_rec}</td>
                                <td>{m.funcionario.nome_func}</td>
                                <td>{m.setor_rec}</td>
                                <td>{m.prioridade_rec}</td>
                                <td>{m.mensagem_rec}</td>
                                <td>
                                </td>
                            </tr>
                        ))

                    }
                </tbody>

                    </Table>







                {/* <body id='container-tickets'>
                {
                msg.map(m => (
                 <ul>
                    <li>Nome Empresa : {m.empresa.nome_emp}</li>
                    <li>Status : {m.status_rec}</li>
                    <li>Operador: {m.funcionario.nome_func}</li>
                    <li>Setor: {m.setor_rec}</li>
                    <li>Prioridade : {m.prioridade_rec}</li>
                    <li id="msgRecado"> mensagem: {m.mensagem_rec}</li>
                    <li>Excluir</li>
                </ul>      
                )
                )
                }
                

            </body> */}

                <div id='carouselBar'>
                    <FiArrowLeft id='carouselIcon' onClick = {() => {setPage(page-1)}}/>
                    <FiArrowRight id='carouselIcon' onClick = {() => {setPage(page+1)}}/>

                    {//operador ternario, se a pagina for zero, não fazer nada. a pagina nao pode ser -1
                    }

                </div>
        </>
            );

}

            export default HomeBody;

    // type GreetingProps = {
    //     name: string;
    //   }

    //   const Greeting:FC<GreetingProps> = ({ name }) => {
    //     // name is string!
    //     return <h1>Hello {name}</h1>
    //   };






    //generics






    // mensagem.map(post => {



    //     <>

    //         <body id='container-tickets'>
    //             <li>
    //                 <ul>Nome Empresa</ul>
    //                 <ul>Status</ul>
    //                 <ul>Operador</ul>
    //                 <ul>Setor</ul>
    //                 <ul>Prioridade</ul>
    //                 <ul id="msgRecado">{post.codigo_rec}</ul>
    //                 <ul>Excluir</ul>
    //             </li>

    //             <li><ul>Nome Empresa</ul>
    //                 <ul>Status</ul>
    //                 <ul>Operador</ul>
    //                 <ul>Setor</ul>
    //                 <ul>Prioridade</ul>
    //                 <ul id="msgRecado">Mensagem</ul>
    //                 <ul>Excluir</ul></li>

    //             <li><ul>Nome Empresa</ul>
    //                 <ul>Status</ul>
    //                 <ul>Operador</ul>
    //                 <ul>Setor</ul>
    //                 <ul>Prioridade</ul>
    //                 <ul id="msgRecado">Mensagem</ul>
    //                 <ul>Excluir</ul></li>


    //         </body>

    //         <div id='carouselBar'>
    //             <FiArrowLeft id='carouselIcon' />
    //             <FiArrowRight id='carouselIcon' />
    //         </div>
    //         <Footer />
    //     </>
    // } 


/* <table>
    <thead>
        <tr>
            <th>Número do pedido</th>
            <th>Quantidade (TN) total pedido</th>
            <th>Quantidade (TN) total entregue</th>
            <th>Data do pedido</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>
        {pedidos.map(pedido => (
            <tr key={pedido.pedido_id}>
                <td>{pedido.pedido_id}</td>
                <td>{pedido.quantity}</td>
                <td>{pedido.quantity_delivered}</td>
                <td>{pedido.pedido_created_at}</td>
                <td>
                <Link to={`order-shipments/${pedido.pedido_id}`}>
                    Visualizar carregamentos
                </Link>
                </td>
            </tr>
        ))}
    </tbody>
</table> */



