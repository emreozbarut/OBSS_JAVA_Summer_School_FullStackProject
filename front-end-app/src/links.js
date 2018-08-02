import React from 'react';
import { Nav, NavItem, NavLink } from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import Image from './java.jpg';
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    UncontrolledDropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem
} from 'reactstrap';

import {
    Carousel,
    CarouselItem,
    CarouselControl,
    CarouselIndicators,
    CarouselCaption
} from 'reactstrap';

const items = [
    {
        src: Image,
        altText: 'Slide 1',
        caption: 'Slide 1'
    },
    {
        src: Image,
        altText: 'Slide 2',
        caption: 'Slide 2'
    },
    {
        src: Image,
        altText: 'Slide 3',
        caption: 'Slide 3'
    }
];

class Slider extends React.Component {
    constructor(props) {
        super(props);
        this.state = { activeIndex: 0 };
        this.next = this.next.bind(this);
        this.previous = this.previous.bind(this);
        this.goToIndex = this.goToIndex.bind(this);
        this.onExiting = this.onExiting.bind(this);
        this.onExited = this.onExited.bind(this);
    }

    onExiting() {
        this.animating = true;
    }

    onExited() {
        this.animating = false;
    }

    next() {
        if (this.animating) return;
        const nextIndex = this.state.activeIndex === items.length - 1 ? 0 : this.state.activeIndex + 1;
        this.setState({ activeIndex: nextIndex });
    }

    previous() {
        if (this.animating) return;
        const nextIndex = this.state.activeIndex === 0 ? items.length - 1 : this.state.activeIndex - 1;
        this.setState({ activeIndex: nextIndex });
    }

    goToIndex(newIndex) {
        if (this.animating) return;
        this.setState({ activeIndex: newIndex });
    }

    render() {
        const { activeIndex } = this.state;

        const slides = items.map((item) => {
            return (
                <CarouselItem
                    onExiting={this.onExiting}
                    onExited={this.onExited}
                    key={item.src}
                >
                    <img src={item.src} alt={item.altText} />
                    <CarouselCaption captionText={item.caption} captionHeader={item.caption} />
                </CarouselItem>
            );
        });

        return (

            <Carousel
                activeIndex={activeIndex}
                next={this.next}
                previous={this.previous}
            >
                <CarouselIndicators items={items} activeIndex={activeIndex} onClickHandler={this.goToIndex} />
                {slides}
                <CarouselControl direction="prev" directionText="Previous" onClickHandler={this.previous} />
                <CarouselControl direction="next" directionText="Next" onClickHandler={this.next} />
            </Carousel>
        );
    }
}


class Navs extends React.Component {
    constructor(props) {
        super(props);

        this.toggle = this.toggle.bind(this);
        this.state = {
            isOpen: false
        };
    }
    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }
    render() {
        return (
            <div>
                <Navbar color="light" light expand="md">
                    <NavbarBrand href="/">BOOK PORTAL</NavbarBrand>
                    <NavbarToggler onClick={this.toggle} />
                    <Collapse isOpen={this.state.isOpen} navbar>
                        <Nav className="ml-auto" navbar>
                            <NavItem>
                                <NavLink href="/">Components</NavLink>
                            </NavItem>
                            <NavItem>
                                <NavLink href="https://github.com/YasinEmreOZBARUT/OBSS_JAVA_Summer_School_FullStackProject">GitHub</NavLink>
                            </NavItem>
                            <UncontrolledDropdown nav inNavbar>
                                <DropdownToggle nav caret>
                                    Options
                  </DropdownToggle>
                                <DropdownMenu right>
                                    <DropdownItem>
                                        Option 1
                    </DropdownItem>
                                    <DropdownItem>
                                        Option 2
                    </DropdownItem>
                                    <DropdownItem divider />
                                    <DropdownItem>
                                        Reset
                    </DropdownItem>
                                </DropdownMenu>
                            </UncontrolledDropdown>
                        </Nav>
                    </Collapse>
                </Navbar>
            </div>
        );
    }
}
class Links extends React.Component {
    render() {
        return (
            <div className="links">
                <Navs />
                <Nav>
                    <NavItem>
                        <NavLink href={"/signup"}>Sign Up</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href={"/login"}>Login</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href={"/main"}>Main</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href={"/delete"}>Delete Book</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href={"/getbooks"}>Get All Books</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href={"/addbook"}>Add Book</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href={"/admin"}>Admin Page</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href={"/usermain"}>User Main Page</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href={"/search"}>Search Book</NavLink>
                    </NavItem>
                </Nav>
                <div style={{ backgroundColor: 'black', textAlign: 'center' }}>
                    <Slider />
                </div>
            </div>
        )
    }
}
export default Links;