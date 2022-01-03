# GithubRepositorySearch
검색어를 이용하여 GitHub에서 리포지토리를 검색한뒤 결과를 목록으로 출력한다.<br />
[GitHub Search API](https://docs.github.com/en/rest/reference/search) 사용

<br />

1. 입력창에 검색할 단어를 입력
2. 우측의 '검색'버튼 클릭
3. 결과 출력

<br />

### 🎞실행화면
https://user-images.githubusercontent.com/45352173/147949362-a2692056-98cc-4501-8fe5-e2ef89954598.mp4

<br/><br/>

### 📚stack
`RecyclerView`, `DataBinding` <br/>
`Retrofit`, `LiveData`

<br/>

ApplicationClass.kt
- 앱 실행 시 바로 실행됨.
- 한번만 실행.
- Retrofit 객체를 singleton 형식으로 생성

<br />

GitHubService.kt
- 비동기화 방식으로 인한 화면출력 문제 해결을 위해 LiveData 사용

<br />

RepoAdapter.kt, BindingAdapter.kt
- RecyclerView와 DataBinding을 함께 사용
