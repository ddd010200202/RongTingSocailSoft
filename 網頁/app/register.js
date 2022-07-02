
// Import the functions you need from the SDKs you need
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.8.2/firebase-app.js";
// import { getAnalytics } from "https://www.gstatic.com/firebasejs/9.8.2/firebase-analytics.js";
import { getAuth, createUserWithEmailAndPassword} from "https://www.gstatic.com/firebasejs/9.8.2/firebase-auth.js";
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

// export  default f;
// const analytics = getAnalytics(app);
// Initialize Firebase Authentication and get a reference to the service
const auth = getAuth(app);

// var name = document.getElementById('name');
// var email = document.getElementById('email');
// var password = document.getElementById('password');
// var submitBtn = document.getElementById('submitBtn');
var submitBtn = document.getElementById('submitBtn');
var loginBtn = document.getElementById('loginBtn');
submitBtn.addEventListener('click', function () {
    event.preventDefault();
    var account = document.getElementById('account').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    createUserWithEmailAndPassword(auth, email, password,account)
        .then((userCredential) => {
            // window.location.href="index.html"
            //sign
            alert('註冊成功')
            const user = userCredential.user;
            console.log(user)
        })
        .catch((error) => {
            const errorCode = error.code;
            const errorMessage = error.message;
            console.log(errorCode);
            console.log(errorMessage)
            alert('註冊失敗')
            // ..
        });
})
loginBtn.addEventListener('click',function(){
    window.location.href ="login.html";
});



