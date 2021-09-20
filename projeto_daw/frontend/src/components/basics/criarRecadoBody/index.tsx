
import { useEffect, useState } from "react";
import api from "../../../services/api";
import { FiArrowLeft, FiArrowRight } from "react-icons/fi";
import '../criarRecadoBody/index.css'
import { Link } from "react-router-dom";

interface imensagem {

    empresa_rec: string,
    status_rec: string,
    prioridade_rec: string,
    setor_rec: string,
    mensagem_rec: string,
    funcionario: ifuncionario,
    empresa: iempresa,
    tipo_rec: string
}

interface ifuncionario {
    nome_func: string;
    cargo_func: string;
    login_func: string;
    senha_func: string;
    tipo_func: string;
}
interface iempresa {
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

const CriarRecadoBody: React.FC = () => {
    const [inputEmpresaRec, setInputEmpresaRec] = useState('');
    const [inputStatus, setInputStatus] = useState('');
    const [inputSetor, setInputSetor] = useState('');
    const [inputPrioridade, setInputPrioridade] = useState('');
    const [inputTipo, setInputTipo] = useState('');
    const [inputMensagem, setInputMensagem] = useState('');
    const [inputFuncionarioId, setInputFuncionarioId] = useState('');
    const [inputEmpresaId, setInputEmpresaId] = useState('');
    
    const [Emp, setEmp] = useState<iempresa[]>([]);
    const [Func, setFunc] = useState<ifuncionario[]>([]);
    const [Msg, setMsg] = useState<imensagem[]>([]);


    async function postMsg() {

        const funcGet = api.get('/v1/elx/funcionarios/' + setInputFuncionarioId)
        setFunc((await funcGet).data)
 
      


        const empGet = api.get('/v1/elx/Empresas/' + setInputEmpresaId)
        setEmp((await empGet).data)

      
        

        const response = api.post('/v1/elx/recados/', {
            //codigo_rec: number,

            "empresa_rec": inputEmpresaRec,
            "status_rec": inputStatus,
            "prioridade_rec": inputPrioridade,
            "setor_rec": inputSetor,
            "mensagem_rec": inputMensagem,
            "funcionario": Func,
            "empresa": Emp,
            "tipo_rec": inputTipo

        });

        window.location.reload();

    }

  



    return (

        <>

            <body id='CriarRecadoBody'>

                <ul id='CriarRecadoUl'>
                    <div id='divH1'>

                        <h1>Empresa: </h1>
                        <h1>Status: </h1>
                        <h1>Prioridade: </h1>
                        <h1>Setor: </h1>
                        <h1>Mensagem: </h1>
                        <h1>Tipo: </h1>
                        <h1>Funcionario ID: </h1>
                        <h1>Empresa ID: </h1>
                        


                    </div>
                    <div id='divInput'>
                        <input type="text" value={inputEmpresaRec} onChange={e => setInputEmpresaRec(e.target.value)} />
                        <input type="text" value={inputStatus} onChange={e => setInputStatus(e.target.value)} />
                        <input type="text" value={inputPrioridade} onChange={e => setInputPrioridade(e.target.value)} />
                        <input type="text" value={inputSetor} onChange={e => setInputSetor(e.target.value)} />
                        <input type="textarea" value={inputMensagem} onChange={e => setInputMensagem(e.target.value)} />
                        <input type="text" value={inputTipo} onChange={e => setInputTipo(e.target.value)} />
                        <input type="text" value={inputFuncionarioId} onChange={e => setInputFuncionarioId(e.target.value)} />
                        <input type="text" value={inputEmpresaId} onChange={e => setInputEmpresaId(e.target.value)} />

                    </div>

                </ul>
                <Link id='linkButton' to='/'>
                    <button onClick={postMsg}>Cadastrar</button>
                </Link>



            </body>



        </>
    );

}

export default CriarRecadoBody;

