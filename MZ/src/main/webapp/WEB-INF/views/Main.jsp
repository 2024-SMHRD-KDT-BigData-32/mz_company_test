<%@page import="com.smhrd.entity.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" type="text/css" href="./resources/mainStyle.css">
  <link rel="stylesheet" type="text/css" href="./resources/mainVars.css">
  
  <style>
   a,
   button,
   input,
   select,
   h1,
   h2,
   h3,
   h4,
   h5,
   * {
       box-sizing: border-box;
       margin: 0;
       padding: 0;
       border: none;
       text-decoration: none;
       background: none;
   
       -webkit-font-smoothing: antialiased;
   }
   
   menu, ol, ul {
       list-style-type: none;
       margin: 0;
       padding: 0;
   }
   </style>
  <title>Document</title>
</head>
<body>
  <div class="main-before">
    <div class="footer">
      <div class="f-nav">
        <div class="frame-1707484334">
          <div class="frame-1707484335">
            <div class="div">고객센터</div>
          </div>
        </div>
        <div class="frame-1707484333">
          <div class="frame-1707484335">
            <div class="div">이용약관</div>
          </div>
        </div>
        <div class="f-p-info">
          <div class="frame-1707484335">
            <div class="div2">개인정보처리방침</div>
          </div>
        </div>
      </div>
      <div class="f-copy">Copyrights ⓒLogoname All rights reserved.</div>
      <div class="f-logo">
        <svg
          class="f-logo-symbol"
          width="24"
          height="25"
          viewBox="0 0 24 25"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M7.32843 22.5C5.54662 22.5 4.65429 20.3457 5.91422 19.0858L9 16H13.5C14.6046 16 15.5 15.1046 15.5 14V9.5L20.5858 14.5858C21.3668 15.3668 21.3668 16.6332 20.5858 17.4142L16.0858 21.9142C15.7107 22.2893 15.202 22.5 14.6716 22.5H7.32843Z"
            fill="#333333"
          />
          <path
            d="M3.91421 8.08579C3.13316 8.86684 3.13317 10.1332 3.91421 10.9142L9 16V11.5C9 10.3954 9.89543 9.5 11 9.5H15.5L18.5858 6.41421C19.8457 5.15428 18.9534 3 17.1716 3H9.82843C9.29799 3 8.78929 3.21071 8.41421 3.58579L3.91421 8.08579Z"
            fill="#333333"
          />
        </svg>
        <div class="f-logo-tit">LOGOTITLE</div>
      </div>
    </div>
    <div class="contest">
      <div class="frame-1707484507">
        <div class="frame-1707484431">
          <div class="contest-tit">
            <div class="div3">공모전에 참여해보세요!</div>
          </div>
          <div class="contest-sub">
            <div class="div4">
              접수중인 공모전을 선택해서 프로젝트를 진행해봐요
            </div>
          </div>
        </div>
        <div class="btn-all">
          <div class="frame-1707484405">
            <div class="div5">전체보기</div>
          </div>
        </div>
      </div>
      <div class="frame-1707484430">
        <div class="contest-box">
          <img class="image" src="./resources/images/image0.png" />
          <div class="frame-1707484422">
            <div class="con-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회</div>
            <div class="frame-1707484421">
              <div class="frame-1707484376">
                <div class="calendar-ico">
                  <svg
                    class="calendar"
                    width="12"
                    height="15"
                    viewBox="0 0 12 15"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      d="M0.0615234 5.76955H11.9442"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                    <path
                      d="M8.69601 0.833374V3.02723"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                    <path
                      d="M3.31027 0.833374V3.02723"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                    <path
                      fill-rule="evenodd"
                      clip-rule="evenodd"
                      d="M8.82551 1.88623H3.18064C1.22285 1.88623 0 2.97685 0 4.98158V11.0147C0 13.0509 1.22285 14.1668 3.18064 14.1668H8.81933C10.7833 14.1668 12 13.0698 12 11.0651V4.98158C12.0062 2.97685 10.7895 1.88623 8.82551 1.88623Z"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                  </svg>
                </div>
                <div class="prj-box-date">2025.03.24</div>
              </div>
              <div class="frame-1707484346"></div>
              <div class="badge">
                <div class="frame-1707484228">
                  <div class="d">마감 임박 D-</div>
                  <div class="_7">7</div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="contest-box">
          <img class="image" src="./resources/images/image1.png" />
          <div class="frame-1707484422">
            <div class="con-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회</div>
            <div class="frame-1707484421">
              <div class="frame-1707484376">
                <div class="calendar-ico">
                  <svg
                    class="calendar2"
                    width="12"
                    height="15"
                    viewBox="0 0 12 15"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      d="M0.0615234 5.76955H11.9442"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                    <path
                      d="M8.69601 0.833374V3.02723"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                    <path
                      d="M3.31027 0.833374V3.02723"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                    <path
                      fill-rule="evenodd"
                      clip-rule="evenodd"
                      d="M8.82551 1.88623H3.18064C1.22285 1.88623 0 2.97685 0 4.98158V11.0147C0 13.0509 1.22285 14.1668 3.18064 14.1668H8.81933C10.7833 14.1668 12 13.0698 12 11.0651V4.98158C12.0062 2.97685 10.7895 1.88623 8.82551 1.88623Z"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                  </svg>
                </div>
                <div class="prj-box-date">2025.03.24</div>
              </div>
              <div class="frame-1707484346"></div>
              <div class="badge">
                <div class="frame-1707484228">
                  <div class="d">마감 임박 D-</div>
                  <div class="_7">7</div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="contest-box">
          <img class="image" src="image2.png" />
          <div class="frame-1707484422">
            <div class="con-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회</div>
            <div class="frame-1707484421">
              <div class="frame-1707484376">
                <div class="calendar-ico">
                  <svg
                    class="calendar3"
                    width="12"
                    height="15"
                    viewBox="0 0 12 15"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      d="M0.0615234 5.76955H11.9442"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                    <path
                      d="M8.69601 0.833374V3.02723"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                    <path
                      d="M3.31027 0.833374V3.02723"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                    <path
                      fill-rule="evenodd"
                      clip-rule="evenodd"
                      d="M8.82551 1.88623H3.18064C1.22285 1.88623 0 2.97685 0 4.98158V11.0147C0 13.0509 1.22285 14.1668 3.18064 14.1668H8.81933C10.7833 14.1668 12 13.0698 12 11.0651V4.98158C12.0062 2.97685 10.7895 1.88623 8.82551 1.88623Z"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                  </svg>
                </div>
                <div class="prj-box-date">2025.03.24</div>
              </div>
              <div class="frame-1707484346"></div>
              <div class="badge">
                <div class="frame-1707484228">
                  <div class="d">마감 임박 D-</div>
                  <div class="_7">7</div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="contest-box">
          <img class="image" src="image3.png" />
          <div class="frame-1707484422">
            <div class="con-box-tit">신용카드 고객 세그먼트 분류 AI 경진대회</div>
            <div class="frame-1707484421">
              <div class="frame-1707484376">
                <div class="calendar-ico">
                  <svg
                    class="calendar4"
                    width="12"
                    height="15"
                    viewBox="0 0 12 15"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      d="M0.0615234 5.76955H11.9442"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                    <path
                      d="M8.69601 0.833374V3.02723"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                    <path
                      d="M3.31027 0.833374V3.02723"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                    <path
                      fill-rule="evenodd"
                      clip-rule="evenodd"
                      d="M8.82551 1.88623H3.18064C1.22285 1.88623 0 2.97685 0 4.98158V11.0147C0 13.0509 1.22285 14.1668 3.18064 14.1668H8.81933C10.7833 14.1668 12 13.0698 12 11.0651V4.98158C12.0062 2.97685 10.7895 1.88623 8.82551 1.88623Z"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                  </svg>
                </div>
                <div class="prj-box-date">2025.03.24</div>
              </div>
              <div class="frame-1707484346"></div>
              <div class="badge">
                <div class="frame-1707484228">
                  <div class="d">마감 임박 D-</div>
                  <div class="_7">7</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="prj">
      <div class="frame-1707484509">
        <div class="frame-1707484409">
          <div class="frame-1707484407">
            <div class="div3">어떤 프로젝트를 원하시나요?</div>
          </div>
          <div class="frame-1707484408">
            <div class="div4">
              실력을 향상시킬 수 있는 다양한 프로젝트가 기다리고 있어요
            </div>
          </div>
        </div>
        <div class="frame-1707484403">
          <div class="btn-stack">
            <div class="frame-1707484405">
              <div class="div5">기술 스택</div>
              <div class="iconly-regular-light-arrow-down-2">
                <div class="iconly-light-arrow-down-2">
                  <svg
                    class="arrow-down-2"
                    width="10"
                    height="6"
                    viewBox="0 0 10 6"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      d="M9.66683 0.666687L5.00016 5.33335L0.333496 0.666687"
                      stroke="#666666"
                      stroke-width="1.5"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                    />
                  </svg>
                </div>
              </div>
            </div>
          </div>
          <div class="btn-all">
            <div class="frame-1707484405">
              <div class="div5">전체보기</div>
            </div>
          </div>
        </div>
      </div>
      <div class="prj-box">
        <div class="frame-1707484397">
          <div class="prj-box2">
            <div class="frame-1707484394">
              <div class="frame-1707484393">
                <div class="frame-1707484388">
                  <div class="prj-sub">공모전 프로젝트</div>
                  <div class="prj-box-tit">
                    신용카드 고객 세그먼트 분류 AI 경진대회 공모전 팀원을 구합니다
                  </div>
                </div>
                <div class="frame-1707484375">
                  <div class="prj-box-stack">
                    <div class="react">React</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="java">Java</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="python">Python</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="figma">Figma</div>
                  </div>
                </div>
              </div>
              <div class="frame-17074843462"></div>
            </div>
            <div class="frame-1707484561">
              <div class="frame-17074843463">
                <div class="frame-1707484376">
                  <div class="calendar-ico">
                    <svg
                      class="calendar5"
                      width="12"
                      height="14"
                      viewBox="0 0 12 14"
                      fill="none"
                      xmlns="http://www.w3.org/2000/svg"
                    >
                      <path
                        d="M0.0615234 5.26955H11.9442"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        d="M8.69601 0.333374V2.52723"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        d="M3.31027 0.333374V2.52723"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M8.82551 1.38623H3.18064C1.22285 1.38623 0 2.47685 0 4.48158V10.5147C0 12.5509 1.22285 13.6668 3.18064 13.6668H8.81933C10.7833 13.6668 12 12.5698 12 10.5651V4.48158C12.0062 2.47685 10.7895 1.38623 8.82551 1.38623Z"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                    </svg>
                  </div>
                  <div class="prj-box-deadline">마감일</div>
                </div>
                <div class="prj-box-date">2025.04.11</div>
              </div>
              <svg
                class="heart-ico"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M3.23225 5.65214C5.33766 3.15453 8.99503 2.90145 11.4012 5.08685L11.9998 5.63053L12.5984 5.08685C15.0046 2.90145 18.6619 3.15453 20.7674 5.65214C22.8728 8.14975 22.6289 11.9461 20.2228 14.1315L11.9998 21.6L3.77685 14.1315C1.37067 11.9461 1.12685 8.14975 3.23225 5.65214Z"
                  stroke="#999999"
                  stroke-width="1.5"
                  stroke-linejoin="round"
                />
              </svg>
            </div>
          </div>
          <div class="prj-box2">
            <div class="frame-1707484394">
              <div class="frame-1707484393">
                <div class="frame-1707484388">
                  <div class="prj-sub">공모전 프로젝트</div>
                  <div class="prj-box-tit">
                    신용카드 고객 세그먼트 분류 AI 경진대회 공모전 팀원을 구합니다
                  </div>
                </div>
                <div class="frame-1707484375">
                  <div class="prj-box-stack">
                    <div class="react">React</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="java">Java</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="python">Python</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="figma">Figma</div>
                  </div>
                </div>
              </div>
              <div class="frame-17074843462"></div>
            </div>
            <div class="frame-1707484561">
              <div class="frame-17074843463">
                <div class="frame-1707484376">
                  <div class="calendar-ico">
                    <svg
                      class="calendar6"
                      width="12"
                      height="14"
                      viewBox="0 0 12 14"
                      fill="none"
                      xmlns="http://www.w3.org/2000/svg"
                    >
                      <path
                        d="M0.0615234 5.26955H11.9442"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        d="M8.69601 0.333374V2.52723"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        d="M3.31027 0.333374V2.52723"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M8.82551 1.38623H3.18064C1.22285 1.38623 0 2.47685 0 4.48158V10.5147C0 12.5509 1.22285 13.6668 3.18064 13.6668H8.81933C10.7833 13.6668 12 12.5698 12 10.5651V4.48158C12.0062 2.47685 10.7895 1.38623 8.82551 1.38623Z"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                    </svg>
                  </div>
                  <div class="prj-box-deadline">마감일</div>
                </div>
                <div class="prj-box-date">2025.04.11</div>
              </div>
              <svg
                class="heart-ico2"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M3.23225 5.65214C5.33766 3.15453 8.99503 2.90145 11.4012 5.08685L11.9998 5.63053L12.5984 5.08685C15.0046 2.90145 18.6619 3.15453 20.7674 5.65214C22.8728 8.14975 22.6289 11.9461 20.2228 14.1315L11.9998 21.6L3.77685 14.1315C1.37067 11.9461 1.12685 8.14975 3.23225 5.65214Z"
                  stroke="#999999"
                  stroke-width="1.5"
                  stroke-linejoin="round"
                />
              </svg>
            </div>
          </div>
          <div class="prj-box2">
            <div class="frame-1707484394">
              <div class="frame-1707484393">
                <div class="frame-1707484388">
                  <div class="prj-sub">공모전 프로젝트</div>
                  <div class="prj-box-tit">
                    신용카드 고객 세그먼트 분류 AI 경진대회 공모전 팀원을 구합니다
                  </div>
                </div>
                <div class="frame-1707484375">
                  <div class="prj-box-stack">
                    <div class="react">React</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="java">Java</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="python">Python</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="figma">Figma</div>
                  </div>
                </div>
              </div>
              <div class="frame-17074843462"></div>
            </div>
            <div class="frame-1707484561">
              <div class="frame-17074843463">
                <div class="frame-1707484376">
                  <div class="calendar-ico">
                    <svg
                      class="calendar7"
                      width="12"
                      height="14"
                      viewBox="0 0 12 14"
                      fill="none"
                      xmlns="http://www.w3.org/2000/svg"
                    >
                      <path
                        d="M0.0615234 5.26955H11.9442"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        d="M8.69601 0.333374V2.52723"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        d="M3.31027 0.333374V2.52723"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M8.82551 1.38623H3.18064C1.22285 1.38623 0 2.47685 0 4.48158V10.5147C0 12.5509 1.22285 13.6668 3.18064 13.6668H8.81933C10.7833 13.6668 12 12.5698 12 10.5651V4.48158C12.0062 2.47685 10.7895 1.38623 8.82551 1.38623Z"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                    </svg>
                  </div>
                  <div class="prj-box-deadline">마감일</div>
                </div>
                <div class="prj-box-date">2025.04.11</div>
              </div>
              <svg
                class="heart-ico3"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M3.23225 5.65214C5.33766 3.15453 8.99503 2.90145 11.4012 5.08685L11.9998 5.63053L12.5984 5.08685C15.0046 2.90145 18.6619 3.15453 20.7674 5.65214C22.8728 8.14975 22.6289 11.9461 20.2228 14.1315L11.9998 21.6L3.77685 14.1315C1.37067 11.9461 1.12685 8.14975 3.23225 5.65214Z"
                  stroke="#999999"
                  stroke-width="1.5"
                  stroke-linejoin="round"
                />
              </svg>
            </div>
          </div>
        </div>
        <div class="frame-1707484400">
          <div class="prj-box2">
            <div class="frame-1707484394">
              <div class="frame-1707484393">
                <div class="frame-1707484388">
                  <div class="prj-sub">공모전 프로젝트</div>
                  <div class="prj-box-tit">
                    신용카드 고객 세그먼트 분류 AI 경진대회 공모전 팀원을 구합니다
                  </div>
                </div>
                <div class="frame-1707484375">
                  <div class="prj-box-stack">
                    <div class="react">React</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="java">Java</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="python">Python</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="figma">Figma</div>
                  </div>
                </div>
              </div>
              <div class="frame-17074843462"></div>
            </div>
            <div class="frame-1707484561">
              <div class="frame-17074843463">
                <div class="frame-1707484376">
                  <div class="calendar-ico">
                    <svg
                      class="calendar8"
                      width="12"
                      height="14"
                      viewBox="0 0 12 14"
                      fill="none"
                      xmlns="http://www.w3.org/2000/svg"
                    >
                      <path
                        d="M0.0615234 5.26955H11.9442"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        d="M8.69601 0.333374V2.52723"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        d="M3.31027 0.333374V2.52723"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M8.82551 1.38623H3.18064C1.22285 1.38623 0 2.47685 0 4.48158V10.5147C0 12.5509 1.22285 13.6668 3.18064 13.6668H8.81933C10.7833 13.6668 12 12.5698 12 10.5651V4.48158C12.0062 2.47685 10.7895 1.38623 8.82551 1.38623Z"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                    </svg>
                  </div>
                  <div class="prj-box-deadline">마감일</div>
                </div>
                <div class="prj-box-date">2025.04.11</div>
              </div>
              <svg
                class="heart-ico4"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M3.23225 5.65214C5.33766 3.15453 8.99503 2.90145 11.4012 5.08685L11.9998 5.63053L12.5984 5.08685C15.0046 2.90145 18.6619 3.15453 20.7674 5.65214C22.8728 8.14975 22.6289 11.9461 20.2228 14.1315L11.9998 21.6L3.77685 14.1315C1.37067 11.9461 1.12685 8.14975 3.23225 5.65214Z"
                  stroke="#999999"
                  stroke-width="1.5"
                  stroke-linejoin="round"
                />
              </svg>
            </div>
          </div>
          <div class="prj-box2">
            <div class="frame-1707484394">
              <div class="frame-1707484393">
                <div class="frame-1707484388">
                  <div class="prj-sub">공모전 프로젝트</div>
                  <div class="prj-box-tit">
                    신용카드 고객 세그먼트 분류 AI 경진대회 공모전 팀원을 구합니다
                  </div>
                </div>
                <div class="frame-1707484375">
                  <div class="prj-box-stack">
                    <div class="react">React</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="java">Java</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="python">Python</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="figma">Figma</div>
                  </div>
                </div>
              </div>
              <div class="frame-17074843462"></div>
            </div>
            <div class="frame-1707484561">
              <div class="frame-17074843463">
                <div class="frame-1707484376">
                  <div class="calendar-ico">
                    <svg
                      class="calendar9"
                      width="12"
                      height="14"
                      viewBox="0 0 12 14"
                      fill="none"
                      xmlns="http://www.w3.org/2000/svg"
                    >
                      <path
                        d="M0.0615234 5.26955H11.9442"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        d="M8.69601 0.333374V2.52723"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        d="M3.31027 0.333374V2.52723"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M8.82551 1.38623H3.18064C1.22285 1.38623 0 2.47685 0 4.48158V10.5147C0 12.5509 1.22285 13.6668 3.18064 13.6668H8.81933C10.7833 13.6668 12 12.5698 12 10.5651V4.48158C12.0062 2.47685 10.7895 1.38623 8.82551 1.38623Z"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                    </svg>
                  </div>
                  <div class="prj-box-deadline">마감일</div>
                </div>
                <div class="prj-box-date">2025.04.11</div>
              </div>
              <svg
                class="heart-ico5"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M3.23225 5.65214C5.33766 3.15453 8.99503 2.90145 11.4012 5.08685L11.9998 5.63053L12.5984 5.08685C15.0046 2.90145 18.6619 3.15453 20.7674 5.65214C22.8728 8.14975 22.6289 11.9461 20.2228 14.1315L11.9998 21.6L3.77685 14.1315C1.37067 11.9461 1.12685 8.14975 3.23225 5.65214Z"
                  stroke="#999999"
                  stroke-width="1.5"
                  stroke-linejoin="round"
                />
              </svg>
            </div>
          </div>
          <div class="prj-box2">
            <div class="frame-1707484394">
              <div class="frame-1707484393">
                <div class="frame-1707484388">
                  <div class="prj-sub">공모전 프로젝트</div>
                  <div class="prj-box-tit">
                    신용카드 고객 세그먼트 분류 AI 경진대회 공모전 팀원을 구합니다
                  </div>
                </div>
                <div class="frame-1707484375">
                  <div class="prj-box-stack">
                    <div class="react">React</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="java">Java</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="python">Python</div>
                  </div>
                  <div class="prj-box-stack">
                    <div class="figma">Figma</div>
                  </div>
                </div>
              </div>
              <div class="frame-17074843462"></div>
            </div>
            <div class="frame-1707484561">
              <div class="frame-17074843463">
                <div class="frame-1707484376">
                  <div class="calendar-ico">
                    <svg
                      class="calendar10"
                      width="12"
                      height="14"
                      viewBox="0 0 12 14"
                      fill="none"
                      xmlns="http://www.w3.org/2000/svg"
                    >
                      <path
                        d="M0.0615234 5.26955H11.9442"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        d="M8.69601 0.333374V2.52723"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        d="M3.31027 0.333374V2.52723"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                      <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M8.82551 1.38623H3.18064C1.22285 1.38623 0 2.47685 0 4.48158V10.5147C0 12.5509 1.22285 13.6668 3.18064 13.6668H8.81933C10.7833 13.6668 12 12.5698 12 10.5651V4.48158C12.0062 2.47685 10.7895 1.38623 8.82551 1.38623Z"
                        stroke="#666666"
                        stroke-width="1.5"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                      />
                    </svg>
                  </div>
                  <div class="prj-box-deadline">마감일</div>
                </div>
                <div class="prj-box-date">2025.04.11</div>
              </div>
              <svg
                class="heart-ico6"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M3.23225 5.65214C5.33766 3.15453 8.99503 2.90145 11.4012 5.08685L11.9998 5.63053L12.5984 5.08685C15.0046 2.90145 18.6619 3.15453 20.7674 5.65214C22.8728 8.14975 22.6289 11.9461 20.2228 14.1315L11.9998 21.6L3.77685 14.1315C1.37067 11.9461 1.12685 8.14975 3.23225 5.65214Z"
                  stroke="#999999"
                  stroke-width="1.5"
                  stroke-linejoin="round"
                />
              </svg>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="banner">
      <div class="frame-1707484156">
        <div class="frame-1707484151">
          <div class="banner-tit">나에게 딱 맞는 프로젝트를 찾아보아요.</div>
          <div class="banner-text">
            원하는 프로젝트와 공모전의 이름 또는 내용을 검색해보세요
          </div>
        </div>
        <div class="visual-search">
          <div class="frame-1707484199">
            <div class="search-left">
              <div class="frame-1707484197">
                <div class="div6">프로젝트</div>
                <svg
                  class="search-more-ico"
                  width="20"
                  height="20"
                  viewBox="0 0 20 20"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M5 7.5L10 12.5L15 7.5"
                    stroke="#767676"
                    stroke-width="1.5"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                </svg>
              </div>
              <div class="div6">검색어를 입력하세요</div>
            </div>
            <div class="search-ico">
              <div class="frame-9">
                <svg
                  class="div7"
                  width="28"
                  height="28"
                  viewBox="0 0 28 28"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M13 21C17.4183 21 21 17.4183 21 13C21 8.58172 17.4183 5 13 5C8.58172 5 5 8.58172 5 13C5 17.4183 8.58172 21 13 21Z"
                    stroke="#767676"
                    stroke-width="2"
                    stroke-miterlimit="10"
                  />
                  <path
                    d="M22.2929 23.7071C22.6834 24.0976 23.3166 24.0976 23.7071 23.7071C24.0976 23.3166 24.0976 22.6834 23.7071 22.2929L22.2929 23.7071ZM17.2929 18.7071L22.2929 23.7071L23.7071 22.2929L18.7071 17.2929L17.2929 18.7071Z"
                    fill="#767676"
                  />
                </svg>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="header">
      <div class="nav-right">
        <div class="frame-1707484481">
          <div class="btn-join">
            <div class="div8">회원가입</div>
          </div>
          <div class="btn-login">
            <div class="div9">로그인</div>
          </div>
        </div>
      </div>
      <div class="nav-left">
        <div class="logo">
          <svg
            class="logo-symbol"
            width="36"
            height="36"
            viewBox="0 0 36 36"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M8.57892 33C6.79711 33 5.90477 30.8457 7.1647 29.5858L13.5005 23.25H21.2505C22.3551 23.25 23.2505 22.3546 23.2505 21.25V13.5L31.5863 21.8358C32.3673 22.6168 32.3673 23.8832 31.5863 24.6642L23.8363 32.4142C23.4612 32.7893 22.9525 33 22.4221 33H8.57892Z"
              fill="#1A72E7"
            />
            <path
              d="M5.1647 12.0858C4.38365 12.8668 4.38365 14.1332 5.1647 14.9142L13.5005 23.25V15.5C13.5005 14.3954 14.3959 13.5 15.5005 13.5H23.2505L29.5863 7.16422C30.8462 5.90429 29.9539 3.75 28.1721 3.75H14.3289C13.7985 3.75 13.2898 3.96072 12.9147 4.33579L5.1647 12.0858Z"
              fill="#1A72E7"
            />
          </svg>
          <div class="logo-text">LOGOTITLE</div>
        </div>
        <div class="gnb">
          <div class="div10">프로젝트 찾기</div>
          <div class="div10">공모전</div>
        </div>
      </div>
    </div>
  </div>
  
</body>
</html>
