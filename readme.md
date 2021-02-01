# RecyclerView Sticky Header/Footer Example



ViewPager2를 사용한 Pagenation,

RecyclerView에 Sticky Header, Footer을 지원하는 리스트 드래그 예제





## [LiveData](https://developer.android.com/topic/libraries/architecture/livedata?hl=ko)

- Data의 변경을 Observe할 수 있는 Data Holder 클래스
  - 일반적인 Observable와는 다르게, 안드로이드 생명주기(LifeCycle)를 갖는다.
  - ViewModel 내의 Data와 UI간의 효율적인 동기화
  - Activity와 함께 destroy되기에, Memory Leak이나 추가적인 Handling에 대한 관리 필요 감소.





## [Koin](https://insert-koin.io/)

- DI 주입 툴
  - 간단하고, 직관적인 사용 방법이 있어 채택.
  - Unit Test가 용이함.
  - 객체 간의 의존성을 줄이거나 없앨 수 있음.






## [Databinding](https://developer.android.com/topic/libraries/data-binding?hl=ko)

- MVVM Model 환경에서 View와 Viewmodel간의 데이터 구성요소 결합을 지원함.
- findViewByid 를 사용하지 않아도 되며, 코드를 단순하고 직관적으로 유지 가능.





## [ViewPager2](https://developer.android.com/jetpack/androidx/releases/viewpager2?hl=ko) 

- RecyclerView와 동일한 Adapter 공유 가능
- 수직 스크롤러 지원
- Data Change Notifity 기능 지원 (notifyDataSetChanged)





## Preview

<img src = "https://github.com/danggai/Recyclerview_Sticky_HeaderFooter_Example/blob/master/preview.gif" width="40%" height="40%">



## Sources

- [Person Icon](https://icons8.com/icons/set/person)
- [Sticky Header Item Decoration](https://github.com/zendesk/zopim-sticky-headers-recyclerview/blob/master/sample/src/main/java/com/timehop/stickyheadersrecyclerview/sample/DividerDecoration.java)
- [Sticky Footer Item Decoration](https://stackoverflow.com/questions/33890709/how-implement-sticky-footer-in-recyclerview)
