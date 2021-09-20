
import { useEffect, useState } from "react";
import api from "../../../services/api";
import { FiArrowLeft, FiArrowRight } from "react-icons/fi";
import '../criarEmpresaBody/index.css'
import { Link } from "react-router-dom";

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

const CriarEmpresaBody: React.FC = () => {
   
    const [Emp, setEmp] = useState<iempresa[]>([]);
    const [inputNomeEmp, setInputNomeEmp] = useState('');
    const [inputRazaoEmp, setInputRazaoEmp] = useState('');
    const [inputCnpjEmp, setInputCnpjEmp] = useState('');
    const [inputEnderecoEmp, setInputEnderecoEmp] = useState('');
    const [inputTelefoneEmp, setInputTelefoneEmp] = useState('');


    async function postMsg() {

        const response = api.post('/v1/elx/Empresas', {
            "nome": inputNomeEmp,
            "razao": inputRazaoEmp,
            "cnpj": inputCnpjEmp,
            "endereco": inputEnderecoEmp,
            "telefone":  inputTelefoneEmp 
        }).then(response => response)
            .catch(error => {
                console.log(error.response)
            });
  


            window.location.reload();

    }




    return (

        <>

            <body id='CriarEmpresaBody'>

                <ul id='CriarEmpresaUl'>
                    <div id='divH1'>
                        
                <h1>Nome: </h1> 
                <h1>Razão: </h1> 
                <h1>Cnpj: </h1>
                <h1>Endereço: </h1>
                <h1>Telefone: </h1>
               

                </div>
                <div id='divInput'>
                <input type="text" value={inputNomeEmp} onChange={e => setInputNomeEmp(e.target.value)} />  
                <input type="text" value={inputRazaoEmp} onChange={e => setInputRazaoEmp(e.target.value)} />
                <input type="text" value={inputCnpjEmp} onChange={e => setInputCnpjEmp(e.target.value)} />
                <input type="text" value={inputEnderecoEmp} onChange={e => setInputEnderecoEmp(e.target.value)} />
                <input type="text" value={inputTelefoneEmp} onChange={e => setInputTelefoneEmp(e.target.value)} />
                    
                </div>
                
            </ul>
            <Link id='linkButton' to='/empresas'>
            <button onClick={postMsg}>Cadastrar</button>
            </Link>



        </body>

              

        </>
            );

}

export default CriarEmpresaBody;

