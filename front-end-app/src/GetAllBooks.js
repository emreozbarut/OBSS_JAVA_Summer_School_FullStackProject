import * as BookAPI from './BookAPI';
import React from 'react';
import image from './java.jpg';
import {
    Container, Row, Col, Card, CardImg, CardBody,
    CardTitle, CardSubtitle, Button
} from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
class BookInfo extends React.Component {
    constructor(props) {
        super(props)
        this.state = { book: [], books: [], query: '', bookID: 1 }
    }

    componentWillMount() {
        BookAPI.getAll().then((books) => {
            if (!books) {
                this.setState({ books: [] })
            } else {
                this.setState({ books: books })
            }
        })
    }
    render() {
        return (
            <Container>
                <Row>
                    {this.state.books.map((book) => (

                        <Col xs="auto">
                            <Card>
                                <CardImg height="350px" src={image} />
                                <CardBody>
                                    <CardTitle>{book.title}</CardTitle>
                                    <CardSubtitle>{book.publishDate}</CardSubtitle>
                                    <Button color="primary">Add to Favorites</Button>
                                    <Button color="primary">Add to Will Reads</Button>
                                </CardBody>
                            </Card>
                        </Col>


                    ))}
                </Row>
            </Container>

        )
    }
}

export default BookInfo;