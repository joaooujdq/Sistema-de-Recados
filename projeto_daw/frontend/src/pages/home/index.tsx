import Footer from 'components/basics/footer';
import Header from 'components/basics/header';
import Title from 'components/basics/title';
import React, { FunctionComponent, useEffect, useState } from "react";
import api from "../../services/api";
import { FiArrowLeft, FiArrowRight } from "react-icons/fi";
import axios from 'axios';
import './index.css'
import { type } from 'os';






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

type ifuncionario = {
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

const Home: React.FC = () => {

    const [codigo, setCodigo] = useState(0);

    function getRecado(mensagem: imensagem) {
        async function buscarRecados1() {

            const response = await api.get('/v1/elx/recados/3')
            console.log(response)
            for (let i = 0; i < 3; i++) {
                let mensagem: imensagem = {
                    codigo_rec: response.data.codigo_rec,
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
                }
                return (

                    <>
                        <Title />
                        <Header />
                        <body id='container-tickets'>

                            <ul>
                                <li>Nome Empresa</li>
                                <li>Status</li>
                                <li>Operador</li>
                                <li>Setor</li>
                                <li>Prioridade</li>
                                <li id="msgRecado">{mensagem.codigo_rec}</li>
                                <li>Excluir</li>
                            </ul>

                        </body>

                        <div id='carouselBar'>
                            <FiArrowLeft id='carouselIcon' />
                            <FiArrowRight id='carouselIcon' />
                        </div>
                        <Footer />
                    </>
                );
            }
        };
    }

}

export default Home;

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



