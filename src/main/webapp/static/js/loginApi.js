function onSignIn(googleUser) {
    let profile = googleUser.getBasicProfile();
    $("#username").text(profile.getEmail());
}



function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
});
}
