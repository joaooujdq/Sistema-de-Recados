
import {  useEffect, useState } from "react";
import api from "../../../services/api";
import { FiArrowLeft, FiArrowRight } from "react-icons/fi";
import { Link } from "react-router-dom";
import './index.css'



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
    const [Limit, setLimit] = useState<imensagem[]>([]);
    const [deleteCodigo, setDeleteCodigo]= useState('');
    const [page, setPage]= useState(0);


    async function loadMsg() {
        
            const response = api.get('/v1/elx/recados/',{params:{page:page,limit:3}});
            const limit = api.get('/v1/elx/recados/');
         
            setMsg((await response).data._embedded.recadoDTOList);
            setLimit((await limit).data._embedded.recadoDTOList);

    }

    async function  deleteMsg() {
        
        const response = api.delete('/v1/elx/recados/' + deleteCodigo);
    }


    useEffect(()=>{
        loadMsg()
    },[page, deleteCodigo]);

    useEffect(()=>{
        loadMsg()
    },[]);



    return (

        <>
          <div id='filter'>
                <h2>Procurar por funcionário: </h2>
                <input id ='filterInput' type="text" />
                </div>
          <body>
              
          
                
                <thead>
                    {
                        Msg.map(m => (
                            <ul id='homeBody'>
                                <li>{m.codigo_rec}</li>
                                <li>{m.empresa.nome_emp}</li>
                                <li>{m.status_rec}</li>
                                <li>{m.funcionario.nome_func}</li>
                                <li>{m.setor_rec}</li>
                                <li>{m.prioridade_rec}</li>
                                <li id='msgRecado'>{m.mensagem_rec}</li>
                                <Link id='linkButton' to='/'>
                                <li id='deleteButton' onClick={() =>{
                                    setDeleteCodigo(m.codigo_rec.toString());
                                    deleteMsg()
                                }}> Excluir</li>
                                </Link>
                            </ul>
                        ))

                    }
               
               </thead>
              
               </body>

                <div id='carouselBar'>
                    <FiArrowLeft id='carouselIcon' onClick = { () => {if( page - 1 >= 0)setPage(page-1)   }  }/>
                    <FiArrowRight id='carouselIcon' onClick = {() =>{if(Msg.length == 3 && page + 1 < Limit.length/3){setPage(page+1)}}}/>

                </div>
        </>
            );

}

            export default HomeBody;

