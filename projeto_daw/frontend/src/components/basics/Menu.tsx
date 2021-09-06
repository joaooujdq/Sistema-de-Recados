interface MenuProps{}

const Menu: React.FC<MenuProps> = (props) => { //generics
    return (
        <h1> {props.children} </h1>
    )
}

export default Menu;


