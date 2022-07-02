// Import the functions you need from the SDKs you need
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.8.2/firebase-app.js";
// import { getAnalytics } from "https://www.gstatic.com/firebasejs/9.8.2/firebase-analytics.js";
import { getAuth, onAuthStateChanged, signOut ,getIdToken} from "https://www.gstatic.com/firebasejs/9.8.2/firebase-auth.js";
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


const auth = getAuth();
// firebase.auth().currentUser.getIdToken(/* forceRefresh */ true).then(function(idToken) {
//     // Send token to your backend via HTTPS
//     // ...
//   }).catch(function(error) {
//     // Handle error
// });




let statechange = function(){onAuthStateChanged(auth, (user) => {
    if (user) {
        // User is signed in, see docs for a list of available properties
        // https://firebase.google.com/docs/reference/js/firebase.User
        const uid = user.uid;
        
        // axios({
        //     method: 'GET',
        //     url: "http://localhost:8083/api/users",
        //     responseType: 'json', // responseType 也可以寫在 header 裡面
        //     headers: {
        //         Authorization: `Bearer ${user.accessToken}` // Bearer 跟 token 中間有一個空格
        //     }
        // })
        //     .then(function (response) {
        //         console.log(response);
        //     })
        //     .catch(function (error) {
        //         console.log('錯誤', error);
        //     });
        // console.log(accessToke)
        document.getElementById('loginbtn').innerText='登出'
        
    } else {
        // window.location.href = "login.html";
        document.getElementById('loginbtn').innerText='登入'
        
    }
})}();



loginbtn.addEventListener("click", function () {
    const auth = getAuth();
    if(document.getElementById('loginbtn').innerText=='登出'){
        signOut(auth).then(() => { 
            alert("登出成功")
            setCookie("token", " ")
                
        }).catch((error) => {
            // An error happened.
        });
        
    }
    
    // setInterval(function () {statechange();},1000)
    if(document.getElementById('loginbtn').innerText=='登入'){
        window.location.href = "login.html";
    }
    

})



