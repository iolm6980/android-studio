# 주제
안드로이드 스튜디오를 활용한 쇼핑몰 제작

# 화면 설계

* 클래스 다이어그램  
  ![image](https://github.com/iolm6980/android-studio/assets/133768355/5e1e9873-6445-4ee5-8a4f-ec53ba29c3ab)  


* 와이어 프레임  
![image](https://github.com/iolm6980/android-studio/assets/133768355/b71200a8-620d-4256-a4f2-422fac7d075d)
![image](https://github.com/iolm6980/android-studio/assets/133768355/1b66a277-de41-454d-84eb-0b44bc7afba7)  


* UI Patterns, Screen Map   
![image](https://github.com/iolm6980/android-studio/assets/133768355/e6e57484-e30c-4f16-a68a-f92353b6d1f4)
![image](https://github.com/iolm6980/android-studio/assets/133768355/2a55172f-3f13-4e77-bc3f-db3f8ac12e03)
![image](https://github.com/iolm6980/android-studio/assets/133768355/8c44edf6-3763-4e8f-90db-6df72cb49031)
![image](https://github.com/iolm6980/android-studio/assets/133768355/76b6010c-9abb-4b5a-a757-e5522fb4c8aa)

# 구현 요소  
![image](https://github.com/iolm6980/android-studio/assets/133768355/81e35033-f872-4a61-a552-2cc247d7ad80)
* 아이템 정보를 담을 DB  
* 리뷰 정보를 담을 DB

# DB설계
![image](https://github.com/iolm6980/android-studio/assets/133768355/b2d6fdde-e0c6-4cdc-b3c9-d6ca06bafdc6)  

인터넷에서 가져온 사진을 이용하여 clothes, outer, pants, shooes를 구성 하위 문서로 document의 이름은 알아서 정해지고   
그 하위문서에 brand, name, img, price로 구성    
임시로 입력한 리뷰를 저장 리뷰는 해당 아이템의 이름과 리뷰 내용으로 구성   

# 구현 결과
* 시작 화면  
![image](https://github.com/iolm6980/android-studio/assets/133768355/a524af07-9ee4-47b6-95f0-9492612ba3d4)  
  
상단의 버튼을 누르면 해당하는 카테고리로 이동  
특별할인 상품 부분은 프래그먼트로 구현  
상의, 하의 등의 부분은 리사이클러 뷰를 수직으로 배치하여 구현  
아이템을 클릭하면 해당 아이템 페이지로 이동  


* 상단의 버튼을 눌렀을 때  
![image](https://github.com/iolm6980/android-studio/assets/133768355/60cd3da7-08b8-4794-a4f4-acce4c78a1e8)   

  
리사이클러뷰를 그리드 형태로 배치하여 구현  
아이템을 클릭하면 해당 아이템 페이지로 이동  

  
* 아이템을 눌렀을 때  
![image](https://github.com/iolm6980/android-studio/assets/133768355/0a96483c-6e73-4b52-98a1-95448de8eae8)  
  
리뷰를 작성하면 데이터베이스에 리뷰가 업로드되고 아래와 같이 리뷰를 출력  






