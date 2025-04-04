<%@page import="com.smhrd.entity.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>프로젝트 및 공모전 플랫폼</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/assets/css/style.css' />">
  	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/assets/css/styleguide.css' />">
  	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/assets/css/globals.css' />">
  
  </head>
  <body>
    <div class="main-before">
      <div class="div">

        <!-- header -->
        <header class="header">
            <nav class="nav-right">
              <a href="#" class="btn-join"><span class="text-wrapper-9">회원가입</span></a>
              <a href="#" class="btn-login"><span class="text-wrapper-10">로그인</span></a>
            </nav>
            <nav class="nav-left">
              <a href="#" class="logo">
                <img class="logo-symbol" src="img/logo-symbol.svg" alt="로고 심볼" />
                <span class="logo-text">LOGOTITLE</span>
              </a>
              <ul class="div-3">
                <li><a href="#" class="text-wrapper-11">프로젝트 찾기</a></li>
                <li><a href="#" class="text-wrapper-11">공모전</a></li>
              </ul>
            </nav>
          </header>

        <!-- 배너 -->
        <section class="banner">
            <div class="frame-19">
              <header class="frame-20">
                <h2 class="banner-tit">나에게 딱 맞는 프로젝트를 찾아보아요.</h2>
                <p class="banner-text">원하는 프로젝트와 공모전의 이름 또는 내용을 검색해보세요</p>
              </header>
              <form class="visual-search" role="search">
                <div class="frame-21">
                  <div class="div-3">
                    <label for="search-type" class="visually-hidden">검색 유형</label>
                    <select id="search-type" class="text-wrapper-8">
                      <option value="project">프로젝트</option>
                      <option value="contest">공모전</option>
                    </select>
                    <img src="./img/search_more_ico.svg">
                    <label for="search-input" class="visually-hidden">검색어 입력</label>
                    <input type="text" id="search-input" class="text-wrapper-8" placeholder="검색어를 입력하세요" />
                  </div>
                  <button type="submit" class="search-ico" aria-label="검색"><img src="./img/search_ico.svg"></button>
                </div>
              </form>
            </div>
        </section>

        <!-- 프로젝트 -->
        <section class="prj">
            <div class="prj_right_wrap">
                <div>
                    <h2 class="text-wrapper-3">어떤 프로젝트를 원하시나요?</h2>
                    <p class="p">실력을 향상시킬 수 있는 다양한 프로젝트가 기다리고 있어요</p>
                  </div>
                  
                  <div class="frame-12">
                    <button class="frame-wrapper">
                      <span class="text-wrapper-4">기술 스택</span>
                      <img class="stack_more_ico" src="./img/search_more_ico.svg" alt="화살표 아이콘" />
                    </button>
                    <button href="#" class="frame-wrapper">
                      <span class="text-wrapper-4">전체보기</span>
                    </button>
                  </div>
            </div>

            <div class="prj-box">
                <div class="frame-13">
                    <article class="prj-box-2">
                        <div class="frame-14">
                        <div class="frame-15">
                            <header class="frame-16">
                            <p class="prj-sub">공모전 프로젝트</p>
                            <h3 class="prj-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회 공모전 팀원을 구합니다</h3>
                            </header>
                            <ul class="div-2">
                            <li class="prj-box-stack"><span class="text-wrapper-7">React</span></li>
                            <li class="prj-box-stack"><span class="text-wrapper-7">Java</span></li>
                            <li class="prj-box-stack"><span class="text-wrapper-7">Python</span></li>
                            <li class="prj-box-stack"><span class="text-wrapper-7">Figma</span></li>
                            </ul>
                        </div>
                        </div>
                        <div class="frame-18">
                        <time class="text-wrapper-5" datetime="2025-04-11">
                            <img class="img" src="./img/calendar_ico.svg" alt="달력 아이콘" />
                            마감일 2025.04.11
                        </time>
                        <button class="heart-ico" aria-label="좋아요"><img src="./img/heart_ico.svg"></button>
                        </div>
                  </article>
                
                <article class="prj-box-2">
                  <div class="frame-14">
                    <div class="frame-15">
                      <header class="frame-16">
                        <p class="prj-sub">공모전 프로젝트</p>
                        <h3 class="prj-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회 공모전 팀원을 구합니다</h3>
                      </header>
                      <ul class="div-2">
                        <li class="prj-box-stack"><span class="text-wrapper-7">React</span></li>
                        <li class="prj-box-stack"><span class="text-wrapper-7">Java</span></li>
                        <li class="prj-box-stack"><span class="text-wrapper-7">Python</span></li>
                        <li class="prj-box-stack"><span class="text-wrapper-7">Figma</span></li>
                      </ul>
                    </div>
                  </div>
                  <div class="frame-18">
                    <time class="text-wrapper-5" datetime="2025-04-11">
                      <img class="img" src="./img/calendar_ico.svg" alt="달력 아이콘" />
                      마감일 2025.04.11
                    </time>
                    <button class="heart-ico" aria-label="좋아요"><img src="./img/heart_ico.svg"></button>
                  </div>
                </article>

                <article class="prj-box-2">
                    <div class="frame-14">
                      <div class="frame-15">
                        <header class="frame-16">
                          <p class="prj-sub">공모전 프로젝트</p>
                          <h3 class="prj-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회 공모전 팀원을 구합니다</h3>
                        </header>
                        <ul class="div-2">
                          <li class="prj-box-stack"><span class="text-wrapper-7">React</span></li>
                          <li class="prj-box-stack"><span class="text-wrapper-7">Java</span></li>
                          <li class="prj-box-stack"><span class="text-wrapper-7">Python</span></li>
                          <li class="prj-box-stack"><span class="text-wrapper-7">Figma</span></li>
                        </ul>
                      </div>
                    </div>
                    <div class="frame-18">
                      <time class="text-wrapper-5" datetime="2025-04-11">
                        <img class="img" src="./img/calendar_ico.svg" alt="달력 아이콘" />
                        마감일 <span class="pjr_date">2025.04.11</span>
                      </time>
                      <button class="heart-ico" aria-label="좋아요"><img src="./img/heart_ico.svg"></button>
                    </div>
                </article>
              </div>

              <div class="frame-13">
                
                <article class="prj-box-2">
                    <div class="frame-14">
                      <div class="frame-15">
                        <header class="frame-16">
                          <p class="prj-sub">공모전 프로젝트</p>
                          <h3 class="prj-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회 공모전 팀원을 구합니다</h3>
                        </header>
                        <ul class="div-2">
                          <li class="prj-box-stack"><span class="text-wrapper-7">React</span></li>
                          <li class="prj-box-stack"><span class="text-wrapper-7">Java</span></li>
                          <li class="prj-box-stack"><span class="text-wrapper-7">Python</span></li>
                          <li class="prj-box-stack"><span class="text-wrapper-7">Figma</span></li>
                        </ul>
                      </div>
                    </div>
                    <div class="frame-18">
                      <time class="text-wrapper-5" datetime="2025-04-11">
                        <img class="img" src="./img/calendar_ico.svg" alt="달력 아이콘" />
                        마감일 2025.04.11
                      </time>
                      <button class="heart-ico" aria-label="좋아요"><img src="./img/heart_ico.svg"></button>
                    </div>
                  </article>

                  <article class="prj-box-2">
                    <div class="frame-14">
                      <div class="frame-15">
                        <header class="frame-16">
                          <p class="prj-sub">공모전 프로젝트</p>
                          <h3 class="prj-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회 공모전 팀원을 구합니다</h3>
                        </header>
                        <ul class="div-2">
                          <li class="prj-box-stack"><span class="text-wrapper-7">React</span></li>
                          <li class="prj-box-stack"><span class="text-wrapper-7">Java</span></li>
                          <li class="prj-box-stack"><span class="text-wrapper-7">Python</span></li>
                          <li class="prj-box-stack"><span class="text-wrapper-7">Figma</span></li>
                        </ul>
                      </div>
                    </div>
                    <div class="frame-18">
                      <time class="text-wrapper-5" datetime="2025-04-11">
                        <img class="img" src="./img/calendar_ico.svg" alt="달력 아이콘" />
                        마감일 2025.04.11
                      </time>
                      <button class="heart-ico" aria-label="좋아요"><img src="./img/heart_ico.svg"></button>
                    </div>
                  </article>

                <article class="prj-box-2">
                    <div class="frame-14">
                      <div class="frame-15">
                        <header class="frame-16">
                          <p class="prj-sub">공모전 프로젝트</p>
                          <h3 class="prj-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회 공모전 팀원을 구합니다</h3>
                        </header>
                        <ul class="div-2">
                          <li class="prj-box-stack"><span class="text-wrapper-7">React</span></li>
                          <li class="prj-box-stack"><span class="text-wrapper-7">Java</span></li>
                          <li class="prj-box-stack"><span class="text-wrapper-7">Python</span></li>
                          <li class="prj-box-stack"><span class="text-wrapper-7">Figma</span></li>
                        </ul>
                      </div>
                    </div>
                    <div class="frame-18">
                      <time class="text-wrapper-5" datetime="2025-04-11">
                        <img class="img" src="./img/calendar_ico.svg" alt="달력 아이콘" />
                        마감일 2025.04.11
                      </time>
                      <button class="heart-ico" aria-label="좋아요"><img src="./img/heart_ico.svg"></button>
                    </div>
                  </article>
              </div>
            </div>
          </section>

        <!-- 공모전 -->
        <section class="contest">
            <div class="prj_right_wrap">
                <div>
                    <h2 class="text-wrapper-3">공모전에 참여해보세요!</h2>
                    <p class="p">접수중인 공모전을 선택해서 프로젝트를 진행해봐요</p>
                  </div>
                  <button class="frame-wrapper">전체보기</button>
            </div>
          
          <div class="frame-5">
            <article class="contest-box">
              <img class="image" src="./img/20250320173728_KSpo.jpg" alt="공모전 이미지" />
              <div class="frame-6">
                <h3 class="con-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회</h3>
                <div class="frame-7">
                  <time class="text-wrapper-5" datetime="2025-03-24">
                    <img class="img" src="./img/calendar_ico.svg" alt="달력 아이콘" />
                    2025.03.24
                  </time>
                  <p class="text-wrapper-6">마감 임박 D-7</p>
                </div>
              </div>
            </article>
            <article class="contest-box">
              <img class="image" src="./img/20250320173728_KSpo.jpg" alt="공모전 이미지" />
              <div class="frame-6">
                <h3 class="con-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회</h3>
                <div class="frame-7">
                  <time class="text-wrapper-5" datetime="2025-03-24">
                    <img class="img" src="./img/calendar_ico.svg" alt="달력 아이콘" />
                    2025.03.24
                  </time>
                  <p class="text-wrapper-6">마감 임박 D-7</p>
                </div>
              </div>
            </article>
            <article class="contest-box">
              <img class="image" src="./img/20250320173728_KSpo.jpg" alt="공모전 이미지" />
              <div class="frame-6">
                <h3 class="con-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회</h3>
                <div class="frame-7">
                  <time class="text-wrapper-5" datetime="2025-03-24">
                    <img class="img" src="./img/calendar_ico.svg" alt="달력 아이콘" />
                    2025.03.24
                  </time>
                  <p class="text-wrapper-6">마감 임박 D-7</p>
                </div>
              </div>
            </article>
            <article class="contest-box">
              <img class="image" src="./img/20250320173728_KSpo.jpg" alt="공모전 이미지" />
              <div class="frame-6">
                <h3 class="con-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회</h3>
                <div class="frame-7">
                  <time class="text-wrapper-5" datetime="2025-03-24">
                    <img class="img" src="./img/calendar_ico.svg" alt="달력 아이콘" />
                    2025.03.24
                  </time>
                  <p class="text-wrapper-6">마감 임박 D-7</p>
                </div>
              </div>
            </article>
          </div>
        </section>
        
        <!-- footer -->
        <footer class="footer">
            <nav class="f-nav">
              <ul>
                <li><a href="#" class="text-wrapper">고객센터</a></li>
                <li><a href="#" class="text-wrapper">이용약관</a></li>
                <li><a href="#" class="text-wrapper-2">개인정보처리방침</a></li>
              </ul>
            </nav>
            <p class="f-copy">Copyrights ⓒLogoname&nbsp;&nbsp;All rights reserved.</p>
            <div class="f-logo">
              <img class="f-logo-symbol" src="img/f-logo-symbol.svg" alt="로고 심볼" />
              <h2 class="f-logo-tit">LOGOTITLE</h2>
            </div>
          </footer>
      </div>
    </div>
  </body>

</html>
