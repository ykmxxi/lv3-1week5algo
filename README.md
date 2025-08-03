# 1week5algo 스터디

## 목적
코딩 테스트 준비!

## 기간
레벨 3 마지막 주까지(~8월 24일 일요일)

## 규칙
- 매주(월요일 ~ 일요일) 해결할 문제는 최소 5문제입니다.
- PR을 매주 일요일 자정까지 제출합니다.

### PR 제출 방법
1. 이 repository를 `fork`한 후, 최상위 프로젝트 폴더에 본인 닉네임으로 폴더를 생성합니다.
2. 본인 닉네임 폴더 하위에 `N주차` 폴더를 생성합니다.
3. 해결한 문제에 대한 커밋을 작성합니다.
4. 새로운 PR 작성 전, rebase를 통해 원격 레포지토리와 커밋 시점을 동일하게 맞추기 위한 작업을 해야 합니다. 그렇지 않으면 이전 커밋 내역이 계속 File Changed에 잡힙니다.
```shell
git remote add upstream https://github.com/7-study-algorithm/lv3-1week5algo.git
git fetch upstream
git checkout main
git rebase upstream/main
```

실수로 rebase를 안하고 PR을 먼저 올린 경우, rebase 후에 force push해주면 File Changed에서 사라집니다.
```shell
git remote add upstream https://github.com/7-study-algorithm/lv3-1week5algo.git
git fetch upstream
git checkout main
git rebase upstream/main

git push -f origin main
```
5. 이 repository에 PR을 작성합니다.
   - PR 제목: {본인 닉네임} - N주차 제출
       - ex) `헤일러 - 1주차 제출`
   - 파일 경로: {본인 닉네임}/{N주차}/{이 하위는 각자 원하는 대로}
       - ex) `헤일러/1주차/BOJ/BOJ22869.java`, `헤일러/1주차/programmers/숫자_타자_대회.java`
   - PR 내용에 본인이 해결한 문제들의 링크를 남겨주세요. 
       - ex) `백준 징검다리 건너기 (small): https://www.acmicpc.net/problem/22869`


## 벌칙
5문제 이상 해결하지 못하거나, PR을 제 시간 안에 올리지 못한 경우 아래 벌칙을 수행해야 합니다.

- 부족한 문제당 2,000원
- PR을 제 시간에 제출하지 못한 경우 10,000원 (5문제 치)

## 구성원

| <img src="https://avatars.githubusercontent.com/u/28076054?v=4" alt="" width=80> | <img src="https://avatars.githubusercontent.com/u/122252160?v=4" alt="" width=80> | <img src="https://avatars.githubusercontent.com/u/83596813?v=4" alt="" width=80> | <img src="https://avatars.githubusercontent.com/u/80245376?v=4" alt="" width=80> | <img src="https://avatars.githubusercontent.com/u/86940801?v=4" alt="" width=80> | <img src="https://avatars.githubusercontent.com/u/42440498?v=4" alt="" width=80> |
| :------------------------------------------------------------------------------: | :-------------------------------------------------------------------------------: | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
|                      [헤일러](https://github.com/threepebbles)                      |                         [부기](https://github.com/changuii)                         | [미소](https://github.com/soeun2537)                                               | [포스티](https://github.com/ykmxxi)                                                 | [수양](https://github.com/ppparkta)                                                | [히스타](https://github.com/Hacanna42)                                              |
