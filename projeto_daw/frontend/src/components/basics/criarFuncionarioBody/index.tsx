
import { useEffect, useState } from "react";
import api from "../../../services/api";
import { FiArrowLeft, FiArrowRight } from "react-icons/fi";
import '../criarFuncionarioBody/index.css'

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

const CriarFuncionarioBody: React.FC = () => {
    const [Msg, setMsg] = useState<imensagem[]>([]);



    async function loadMsg() {

        const response = api.get('/v1/elx/recados/');
        setMsg((await response).data._embedded.recadoDTOList);




    }

    useEffect(() => {
        loadMsg()
    });



    return (

        <>

            <body id='CriarFuncionarioBody'>
                
                
                <ul id='CriarFuncionarioUl'>
                    <div id='divH1'>
                        
                <h1>Empresa: </h1> 
                <h1>Status: </h1> 
                <h1> Funcionario: </h1>
                <h1>Setor: </h1>
                <h1>Prioridade: </h1>
                <h1>Mensagem: </h1>

                </div>
                <div id='divInput'>
                    <input type="text" />
                    <input type="text" />
                    <input type="text" />
                    <input type="text" />
                    <input type="text" />
                    <input type="text" />
                    
                </div>
                
            </ul>
            
            <button>Cadastrar</button>




        </body>

              

        </>
            );

}

export default CriarFuncionarioBody;

