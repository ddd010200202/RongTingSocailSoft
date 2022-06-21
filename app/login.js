
// Import the functions you need from the SDKs you need
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.8.2/firebase-app.js";
// import { getAnalytics } from "https://www.gstatic.com/firebasejs/9.8.2/firebase-analytics.js";
import { getAuth, signInWithEmailAndPassword, GoogleAuthProvider, signInWithPopup, signInWithRedirect, getRedirectResult } from "https://www.gstatic.com/firebasejs/9.8.2/firebase-auth.js";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyBbhqF-rMpXMDe9GH4cgMluov4SuK1NixM",
    authDomain: "rongtingcompany-ab3b7.firebaseapp.com",
    projectId: "rongtingcompany-ab3b7",
    storageBucket: "rongtingcompany-ab3b7.appspot.com",
    messagingSenderId: "1027589062469",
    appId: "1:1027589062469:web:d03f56fd5cdebb6465882c",
    measurementId: "G-ERXDJRLMJV"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

// Initialize Firebase Authentication and get a reference to the service
const auth = getAuth(app);

var submitBtn = document.getElementById('submitBtn');

submitBtn.addEventListener('click', function () {
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    event.preventDefault();
    signInWithEmailAndPassword(auth, email, password)
        .then((userCredential) => {
            // Signed in 
            alert('登入成功')
            
            const user = userCredential.user;
            console.log(user)
            console.log(userCredential.uid)
            window.location.href = "index.html"
        })
        .catch((error) => {
            const errorCode = error.code;
            const errorMessage = error.message;
            console.log(errorMessage)
            console.log(errorCode)
        });
});

//google 註冊
const provider = new GoogleAuthProvider();
provider.addScope('https://www.googleapis.com/auth/contacts.readonly');

var googleBtn = document.getElementById('googleBtn');
googleBtn.addEventListener('click', function () {
    
    signInWithPopup(auth, provider)
    .then((result) => {
        // alert('登入成功')
        
        
        window.location.href = "homepage.html"
        // This gives you a Google Access Token. You can use it to access the Google API.
        const credential = GoogleAuthProvider.credentialFromResult(result);
        const token = credential.accessToken;
        // The signed-in user info.
        const user = result.user;
        // ...
    }).catch((error) => {

        // Handle Errors here.
        const errorCode = error.code;
        const errorMessage = error.message;
        // The email of the user's account used.
        const email = error.email;
        // The AuthCredential type that was used.
        const credential = GoogleAuthProvider.credentialFromError(error);
        // ...
        console.log(errorMessage)
        console.log(errorCode)
        console.log(email)
        console.log(credential)

    });

    // signInWithRedirect(auth, provider)
    //     .then((result) => {
    //         // This gives you a Google Access Token. You can use it to access the Google API.
    //         const credential = GoogleAuthProvider.credentialFromResult(result);
    //         const token = credential.accessToken;
    //         // The signed-in user info.
    //         const user = result.user;
    //         // ...
    //     }).catch((error) => {

    //         // Handle Errors here.
    //         const errorCode = error.code;
    //         const errorMessage = error.message;
    //         // The email of the user's account used.
    //         const email = error.email;
    //         // The AuthCredential type that was used.
    //         const credential = GoogleAuthProvider.credentialFromError(error);
    //         // ...
    //         console.log(errorMessage)
    //         console.log(errorCode)
    //         console.log(email)
    //         console.log(credential)

    //     });

})




var registerBtn = document.getElementById('registerBtn');
registerBtn.addEventListener('click', function () {
    window.location.href = "register.html";
});