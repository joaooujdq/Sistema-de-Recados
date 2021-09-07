import Footer from 'components/basics/footer';
import Header from 'components/basics/header';
import Title from 'components/basics/title';
import { FiArrowLeft, FiArrowRight } from "react-icons/fi";
import './index.css'

const Home: React.FC = () => {
    return (
        <>
        <Title/>
        <Header/>
        <body id= 'container-tickets'>
            <li>
                <ul>Nome Empresa</ul>
                <ul>Status</ul>
                <ul>Operador</ul>
                <ul>Setor</ul>
                <ul>Prioridade</ul>
                <ul id= "msgRecado">Mensagem</ul>
                <ul>Excluir</ul>
            </li>

            <li><ul>Nome Empresa</ul>
                <ul>Status</ul>
                <ul>Operador</ul>
                <ul>Setor</ul>
                <ul>Prioridade</ul>
                <ul id= "msgRecado">Mensagem</ul>
                <ul>Excluir</ul></li>

            <li><ul>Nome Empresa</ul>
                <ul>Status</ul>
                <ul>Operador</ul>
                <ul>Setor</ul>
                <ul>Prioridade</ul>
                <ul id= "msgRecado">Mensagem</ul>
                <ul>Excluir</ul></li>
        </body>

        <div id= 'carouselBar'>
        <FiArrowLeft id='carouselIcon'/>
        <FiArrowRight id='carouselIcon'/>
        </div>
        <Footer/>
        </>
    );
}

export default Home;
