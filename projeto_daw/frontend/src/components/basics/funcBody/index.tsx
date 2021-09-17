
import {  useEffect, useState } from "react";
import api from "../../../services/api";
import { FiArrowLeft, FiArrowRight } from "react-icons/fi";
import '../funcBody/index.css'

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

const FuncBody: React.FC = () => {
    const [Msg, setMsg] = useState<imensagem[]>([]);
    const [page, setPage]= useState(0);


    async function loadMsg() {
        const response = api.get('/v1/elx/recados/',{params:{page:page,limit:3}});
        setMsg((await response).data._embedded.recadoDTOList);

     
    }

    useEffect(()=>{
        loadMsg()
    },[page]);



    return (

        <>
          
          <body>
              
          
                
                <thead>
                    {
                        Msg.map(m => (
                            <ul id='funcBody'>
                                <li>{m.funcionario.codigo_func}</li>
                                <li>{m.funcionario.nome_func}</li>
                                <li>{m.funcionario.cargo_func}</li>
                                <li>{m.funcionario.tipo_func}</li>
                                <li id='deleteButton'>Excluir</li>
                            </ul>
                        ))

                    }
               
               </thead>
              
               </body>

               <div id='carouselBar'>
                    <FiArrowLeft id='carouselIcon' onClick = { () => {if( page - 1 >= 0)setPage(page-1)   }  }/>
                    <FiArrowRight id='carouselIcon' onClick = {() => {if(Msg.length == 3)setPage(page+1)   }  }/>

                </div>

        </>
            );

}

            export default FuncBody;

