import React from 'react';
import Post from './Post';
class Posts extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            posts: [],
            hasError: false
        };
    }
    loadPosts(){
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                const postsData = data.map(item => new Post(item.id, item.title, item.body));
                this.setState({ posts: postsData });
            })
            .catch(error => {
                console.error("Fetch error:", error);
                this.setState({ hasError: true });
            });
    }
    componentDidMount(){
        this.loadPosts();
    }
    render(){
        if (this.state.hasError) {
            return <h2>Something went wrong.</h2>;
        }

        return (
            <div>
                <h1>Blog Posts</h1>
                {this.state.posts.map(post => (
                    <div key={post.id}>
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                        <hr />
                    </div>
                ))}
            </div>
        );
    }

    componentDidCatch(error,info){
        alert("An error occurred in Posts component.");
        console.error("Error:", error, "Info:", info);
        this.setState({ hasError: true });
    }
    
}
export default Posts;