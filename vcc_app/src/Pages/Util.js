export function setSession(user)
{
    sessionStorage.setItem("uid",user.id);
    sessionStorage.setItem("userinfo",JSON.stringify(user));
}

export function sessionLogout(){
    sessionStorage.removeItem("uid");
    sessionStorage.removeItem("userinfo");
    window.location="./";
}

export function getUserInfo()
{
    return sessionStorage.getItem("userinfo");
}