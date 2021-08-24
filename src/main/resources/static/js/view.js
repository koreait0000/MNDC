const likeBtn = document.getElementById("like-btn");
const bpk = likeBtn.dataset.bpk;
const mpk = likeBtn.dataset.mpk;


likeBtn.addEventListener("click", () =>{
    addLike(bpk,mpk);
});

function addLike(bpk,mpk){
    fetch(`/board/addLike?bpk=${bpk}&mpk=${mpk}`)
        .then(res => res.json())
        .then(myjson =>{
            console.log(myjson);
            likeBtn.innerText = `추천하기 ${myjson}`;
        })
}